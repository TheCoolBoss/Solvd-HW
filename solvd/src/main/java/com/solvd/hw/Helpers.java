package com.solvd.hw;

import java.util.ArrayList;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.function.*;

import com.solvd.hw.enums.Court;
import com.solvd.hw.enums.LicenseType;
import com.solvd.hw.enums.SecretaryWork;
import com.solvd.hw.enums.Timezone;
import com.solvd.hw.exceptions.*;
import com.solvd.hw.lambdas.Filters;

public class Helpers 
{
    private static final Logger LOGGER = LogManager.getLogger(Helpers.class);
    
    public ArrayList<LawFirm> initLawFirms()
    {
        ArrayList<LawFirm> lawFirms = new ArrayList<LawFirm>();
        LawFirm theLaw = new LawFirm("The Law", Court.FEDERAL);
        LawFirmPhysical theLawPhysical = new LawFirmPhysical(theLaw.getName(), "USA", Court.STATE);
        LawFirmRemote theLawRemote = new LawFirmRemote(theLaw.getName(), Timezone.PST, "thelaw.com", Court.FEDERAL);
        lawFirms.add(theLaw);
        lawFirms.add(theLawPhysical);
        lawFirms.add(theLawRemote);

        return lawFirms;
    }

    public void initEmployees(LawFirm firm)
    {
        //Can't do licenses or plans since editing one will affect lawyers that use the same one

        //Secretaries
        Secretary janeDoe = new Secretary("Jane", "Doe", 10, "5/4/32");
        Secretary janeDoe2 = new Secretary("Jane", "Doe 2", 11, "5/4/32");
        janeDoe.getWorkList().add(SecretaryWork.SHRED);

        //Actual lawyers
        Lawyer mattJohnson = new Lawyer("Matthew", "Johnson", new Plan(50.00, 10.00), new License(LicenseType.BASIC), janeDoe, "4/20/23", 1);
        Lawyer numberLawyer = new Lawyer("1", "2", new Plan(80.00, 7.00), new License(LicenseType.BASIC), janeDoe, "4/4", 2);
        Lawyer snake = new Lawyer("Solid", "Snake", new Plan(30.00, 15.00), new License(LicenseType.ADVANCED), janeDoe2, "1/1/11", 3);
        LawyerRemote remoteLawyer = new LawyerRemote("The", "Remote Lawyer", new Plan(50.00, 10.00), new License(LicenseType.OTHER), janeDoe2, "1/2/34", 5, Timezone.PST);

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
            LOGGER.error("Law firm " + firm.getName() + " is closed.");
        }

    }

    public void initRemoteEmployees(LawFirm remoteFirm, LawFirm sourceFirm)
    {
        ArrayList<Lawyer> remoteLawyers = Filters.REMOTE_LAWYERS.filter(sourceFirm.getLawyers());
        remoteLawyers.stream().forEach((lawyer) -> remoteFirm.getLawyers().add(lawyer));
    }

    public void initClients(LawFirm firm)
    {
        Client angryConsumer1 = new Client("Angry", "Consumer");
        Client saltyPerson = new Client();

        firm.getClients().add(saltyPerson);
        firm.getClients().add(angryConsumer1);
    }

    public void initCases(LawFirm firm)
    {
        Case privateCase1 = new Case("Dummy Case", "4/16", "Test Plaintiff", "Test Defendant", 72);
        Case defamation1 = new CaseDefamation("Defamation 1", "4/22", "Plaintiff", "Defendant", 240);
        Case private1 = new Case("5/12", "P,", "D", 5);

        firm.getCases().add(defamation1);
        firm.getCases().add(privateCase1);
        firm.getCases().add(private1);
    }

    public void initEmployeeWork(LawFirm firm)
    {

    }

    public void clearLawFirms(ArrayList<LawFirm> firms)
    {
        //ConcurrentModificationException happens if removing is done during iteration
        ArrayList<Integer> indicesToRemove = new ArrayList<Integer>();

        for (LawFirm firm : firms) 
        {
            if (firm.getName().contains("closed"))
            {
                LOGGER.info("Removing law firm " + firm.getName());
                indicesToRemove.add(firms.indexOf(firm));
            }
        }

        Consumer<ArrayList<Integer>> remover = (ArrayList<Integer> list) -> list.stream().forEach(i -> firms.remove(i.intValue()));
        remover.accept(indicesToRemove);
    }
}
