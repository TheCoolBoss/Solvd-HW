package com.hw2;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Main 
{
    public static void main(String[] args)
    {
        Logger log = Logger.getLogger("Main");
        FileHandler fh;

        try
        {
            fh = new FileHandler("logs.log");
            log.addHandler(fh);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a law firm name");
        String name = scanner.nextLine();

        try 
        {
            Helpers.checkLength(name);
        }

        catch (Exception e)
        {
            System.out.println("String was invalid. Using a default value now.");
            name = "Default Name";
        }

        finally
        {
            scanner.close();
        }

        
        ArrayList<LawFirm> lawFirms = Helpers.initLawFirms();
        lawFirms.add(new LawFirm(name));
        LawFirm theLaw = lawFirms.get(0);
        Helpers.initEmployees(theLaw);
        Helpers.initCases(theLaw);
        Helpers.initClients(theLaw);

        for (LawFirm lawFirm : lawFirms) 
        {
            log.info(lawFirm.toString());    
        }
        Helpers.printBreak();
        Client client1 = theLaw.getClients().get(0);

        //Used for testing
        //client1.addCase(theLaw.cases.get(0));
        //client1.addCase(theLaw.getCases().get(1));

        theLaw.getLawyers().get(0).fire();
        Case firedCase = new Case("Fired Case", "The Law", "Lawyer", 6);

        //Attempt to add a case to a fired lawyer
        try
        {
            theLaw.getLawyers().get(0).addCase(firedCase);
        }

        catch (InvalidLicenseException ile)
        {
            log.info(ile.getMessage());
        }

        //Attempt to print costs when a client has no cases
        try
        {
            client1.printCosts(theLaw);
        }

        catch (NoCasesFoundException ncfe)
        {
           log.info(ncfe.getMessage());
        }

        //Attempt to add an employee to a closed law firm (should fail)
        theLaw.closeDown();
        try
        {
            theLaw.addEmployee(new Lawyer("A", "b", new Plan(5.0), new License("t"), null, "1", 9));
        }

        catch (ClosedLawFirmException clfe)
        {
            log.info(clfe.getMessage());
        }
        
    }    
}
