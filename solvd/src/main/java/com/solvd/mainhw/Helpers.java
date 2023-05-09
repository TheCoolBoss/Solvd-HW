package com.solvd.mainhw;

import java.util.ArrayList;
import org.apache.logging.log4j.Logger;
import com.solvd.mainhw.exceptions.*;

public class Helpers 
{
    public static ArrayList<LawFirm> initLawFirms()
    {
        ArrayList<LawFirm> lawFirms = new ArrayList<LawFirm>();
        LawFirm theLaw = new LawFirm("The Law");
        LawFirmPhysical theLawPhysical = new LawFirmPhysical(theLaw.getName(), "USA");
        LawFirmRemote theLawRemote = new LawFirmRemote(theLaw.getName(), "PST", "thelaw.com");
        lawFirms.add(theLaw);
        lawFirms.add(theLawPhysical);
        lawFirms.add(theLawRemote);

        return lawFirms;
    }

    public static void initEmployees(LawFirm firm, Logger logger)
    {
        //Plans for lawyers to use
        Plan basicPlan = new Plan(50.00, 10.00);
        Plan moreHoursPlan = new Plan(80.00, 7.00);
        Plan fewHoursPlan = new Plan(30.00, 15.00);

        //Licenses
        License basicLicense = new License("Basic");
        License advancedLicense = new License("Advanced");

        //Secretaries
        Secretary janeDoe = new Secretary("Jane", "Doe", 10, "5/4/32");
        Secretary janeDoe2 = new Secretary("Jane", "Doe 2", 11, "5/4/32");

        //Actual lawyers
        Lawyer mattJohnson = new Lawyer("Matthew", "Johnson", basicPlan, basicLicense, janeDoe, "4/20/23", 1);
        Lawyer numberLawyer = new Lawyer("1", "2", moreHoursPlan, basicLicense, janeDoe, "4/4", 2);
        Lawyer snake = new Lawyer("Solid", "Snake", fewHoursPlan, advancedLicense, janeDoe2, "1/1/11", 3);
        LawyerRemote remoteLawyer = new LawyerRemote("The", "Remote Lawyer", basicPlan, advancedLicense, janeDoe2, "1/2/34", 5);

        try
        {
            firm.addEmployee(mattJohnson);
            firm.addEmployee(numberLawyer);
            firm.addEmployee(snake);
            firm.addEmployee(remoteLawyer);
            firm.addEmployee(janeDoe);
            firm.addEmployee(janeDoe2);
        }

        catch (ClosedLawFirmException clfe)
        {
            logger.error("Law firm " + firm.name + " is closed.");
        }

    }

    public static void initClients(LawFirm firm)
    {
        Client angryConsumer1 = new Client("Angry", "Consumer");
        Client saltyPerson = new Client();

        firm.getClients().add(saltyPerson);
        firm.getClients().add(angryConsumer1);
    }

    public static void initCases(LawFirm firm)
    {
        Case privateCase1 = new Case("Dummy Case", "4/16", "Test Plaintiff", "Test Defendant", 72);
        Case defamation1 = new CaseDefamation("Defamation 1", "4/22", "Plaintiff", "Defendant", 240);
        
        firm.getCases().add(defamation1);
        firm.getCases().add(privateCase1);
    }

    public static void clearLawFirms(ArrayList<LawFirm> firms, Logger logger)
    {
        //ConcurrentModificationException happens if removing is done during iteration
        ArrayList<Integer> indicesToRemove = new ArrayList<Integer>();

        for (LawFirm firm : firms) 
        {
            if (firm.getName().contains("closed"))
            {
                logger.info("Removing law firm " + firm.getName());
                indicesToRemove.add(firms.indexOf(firm));
            }
        }

        for (Integer index : indicesToRemove)
        {
            firms.remove(index.intValue());
        }
    }
}
