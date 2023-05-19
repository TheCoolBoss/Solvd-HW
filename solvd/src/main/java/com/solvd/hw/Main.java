package com.solvd.hw;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw.enums.Court;
import com.solvd.hw.enums.LicenseType;
import com.solvd.hw.enums.Session;
import com.solvd.hw.exceptions.*;
import com.solvd.hw.lambdas.*;
import java.util.function.*;

public class Main 
{
    private static final Logger LOGGER = LogManager.getLogger("Main");
    private static final Helpers INIT = new Helpers();

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


        ArrayList<LawFirm> lawFirms = INIT.initLawFirms();
        Supplier<LawFirm> firmFetcher = () -> lawFirms.get(0);
        
        LawFirm theLaw = firmFetcher.get();
        INIT.initEmployees(theLaw);
        INIT.initCases(theLaw);
        INIT.initClients(theLaw);
        INIT.initRemoteEmployees(lawFirms.get(2), theLaw);

        Plan customPlan = new Plan (14.00, 4.00);
        License customLicense = new License(LicenseType.OTHER);
        Lawyer customLawyer = new Lawyer("The", "Custom", customPlan, customLicense, null, "5/8", 513);
        customLawyer.addSession(Session.IN_PERSON);
        LawFirm customFirm = new LawFirm(scannerName, Court.STATE);
        try
        {
            customFirm.addEmployee(customLawyer);
        }

        catch (ClosedLawFirmException clfe)
        {
            LOGGER.error(clfe.getMessage());
        }

        theLaw.getSubsidiaries().addNode(customFirm);
        lawFirms.add(customFirm);
        theLaw.addCasesToLawyer(theLaw.getCases(), customLawyer, Adders.CASE_ADDER);

        LOGGER.info("Info about all law firms:\n");
        lawFirms.stream().forEach(lawFirm -> LOGGER.info(lawFirm.toString()));

        LOGGER.info("Init complete.\n");
        Client client1 = theLaw.getClients().get(0);


        while (true)
        {

            LOGGER.info("Listing costs for client " + client1.getFirstName() + " " + client1.getLastName());
            lawFirms.forEach(lawFirm -> 
            {
                try
                {
                    lawFirm.printCosts(client1);
                }

                catch (NoCasesFoundException ncfe)
                {
                    LOGGER.error(ncfe.getMessage());
                    LOGGER.info("Adding public cases from law firm " + theLaw.getName() + " to client.");
                    LOGGER.info("For reference, they are:\n" + theLaw.filterCasesByName(Filters.PUBLIC_CASES).toString() +"\n");
                    theLaw.addCasesToClient(theLaw.filterCasesByName(Filters.PUBLIC_CASES), client1, Adders.CASE_ADDER);
                }
            });

            break;
        }
    }    
}
