package com.solvd.hw;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw.exceptions.*;
import java.util.function.*;

public class Main 
{
    static final Logger LOGGER = LogManager.getLogger("Main");

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Please input a law firm subsidiary name");
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
        Supplier<LawFirm> firmFetcher = () -> lawFirms.get(0);
        
        LawFirm theLaw = firmFetcher.get();
        Helpers.initEmployees(theLaw, LOGGER);
        Helpers.initCases(theLaw);
        Helpers.initClients(theLaw);

        Plan customPlan = new Plan (14.00, 4.00);
        License customLicense = new License("Custom");
        Lawyer customLawyer = new Lawyer("The", "Custom", customPlan, customLicense, null, "5/8", 513);
        LawFirm customFirm = new LawFirm(scannerName);
        try
        {
            customFirm.addEmployee(customLawyer);
        }

        catch (ClosedLawFirmException clfe)
        {
            LOGGER.error(clfe.getMessage());
        }

        theLaw.getsubsidiaries().addNode(customFirm);
        lawFirms.add(customFirm);

        LOGGER.info("Info about all law firms:\n");
        for (LawFirm lawFirm : lawFirms) 
        {
            LOGGER.info(lawFirm.toString());    
        }

        LOGGER.info("Init complete.\n");
        Client client1 = theLaw.getClients().get(0);

        while (true)
        {
            try
            {
                LOGGER.info("Listing costs for client " + client1.getFirstName() + " " + client1.getLastName());
                for (LawFirm lawFirm : lawFirms) 
                {
                    lawFirm.printCosts(client1, LOGGER);
                }

                break;
            }
    
            catch (NoCasesFoundException ncfe)
            {
                LOGGER.error(ncfe.getMessage());
                LOGGER.info("Adding cases from law firm " + theLaw.getName() + " to law firm " + customFirm.getName());
                for (Case c : theLaw.getCases()) 
                {
                    client1.addCase(c);
                }
            }
        }
    }    


}
