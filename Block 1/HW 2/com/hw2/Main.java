package com.hw2;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main 
{
    public static void main(String[] args)
    {
        final Logger LOGGER = LogManager.getLogger(Main.class);
        LinkedList<Integer> testList = new LinkedList<Integer>(1);
        System.out.println(LOGGER.isInfoEnabled());
        testList.addNode(2);
        testList.addNode(3);
        testList.printList(testList);
        testList.removeNode(5);
        testList.removeNode(3);
        testList.printList(testList);

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

        LOGGER.info("test");
        for (LawFirm lawFirm : lawFirms) 
        {
            LOGGER.info(lawFirm.toString());    
        }
        Helpers.printBreak();
        Client client1 = theLaw.getClients().get(0);

        try
        {
            client1.printCosts(theLaw);
        }

        catch (NoCasesFoundException ncfe)
        {
            LOGGER.error(ncfe.getMessage());
            LOGGER.info("Adding cases from law firm " + theLaw.getName());
            for (Case c : theLaw.getCases()) 
            {
                client1.addCase(c);
            }
        }

        //Need to figure out how to just loop above
        try
        {
            client1.printCosts(theLaw);
        }

        catch (NoCasesFoundException ncfe)
        {
            LOGGER.error(ncfe.getMessage());
        }
    }    
}
