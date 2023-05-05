package com.mycompany.app;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.mycompany.app.Exceptions.*;

public class Main 
{
    private static final Logger LOGGER = LogManager.getLogger("Main");

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Please input a law firm name");
        String scannerName;
        try 
        {
            scannerName = scanner.nextLine();

        }

        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
            scannerName = "Default Name";
        }

        scanner.close();

        ArrayList<LawFirm> lawFirms = Helpers.initLawFirms();
        LawFirm theLaw = lawFirms.get(0);
        Helpers.initEmployees(theLaw, LOGGER);
        Helpers.initCases(theLaw);
        Helpers.initClients(theLaw);


        LawFirm customFirm = new LawFirm(scannerName);
        lawFirms.add(customFirm);
        

        Plan aureliaPlan = new Plan(6.0, 4.0);
        License guildmaster = new License("Guildmaster");
        Secretary tajic = new Secretary("Tajic", "", 107, "2013");
        Lawyer aurelia = new Lawyer("Aurelia", "", aureliaPlan, guildmaster, tajic, "2013", 143);
        try
        {
            customFirm.addEmployee(aurelia);
            customFirm.addEmployee(tajic);
        }

        catch (ClosedLawFirmException clfe)
        {
            LOGGER.error(clfe.getMessage());
        }

        
        for (LawFirm lawFirm : lawFirms) 
        {
            LOGGER.info(lawFirm.toString());    
        }

        printBreak();
        Client client1 = theLaw.getClients().get(0);

        while (true)
        {
            try
            {
                customFirm.printCosts(client1, LOGGER);
                break;
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
        }
    }    

    public static void printBreak()
    {
        LOGGER.info("");
    }
}
