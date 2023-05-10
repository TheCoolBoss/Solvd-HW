package com.solvd.hw;

import java.util.ArrayList;
import java.util.function.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw.enums.LicenseType;
import com.solvd.hw.exceptions.*;
import com.solvd.hw.interfaces.*;

public class LawFirm implements CanBeShutDown
{
    private static final Logger LOGGER = LogManager.getLogger(LawFirm.class);
    private static final String COUNTRY = "USA";
    
    private String name; 
    private ArrayList<Lawyer> lawyers;
    private ArrayList<Secretary> secretaries;
    private ArrayList<Client> clients;
    private ArrayList<Case> cases;
    private LinkedList<LawFirm> subsidiaries;
    private boolean isOpen;

    static
    {
        System.out.println("Establishing new law firm in " + COUNTRY + ".");
    }

    public LawFirm(String name)
    {
        this.name = name;
        this.lawyers = new ArrayList<Lawyer>();
        this.clients = new ArrayList<Client>();
        this.secretaries = new ArrayList<Secretary>();
        this.cases = new ArrayList<Case>();
        this.subsidiaries = new LinkedList<LawFirm>();
        this.isOpen = true;
    }

    public String getName()
    {
        return this.name;
    }

    public ArrayList<Lawyer> getLawyers()
    {
        return this.lawyers;
    }

    public ArrayList<Secretary> getSecretaries()
    {
        return this.secretaries;
    }
    
    public LinkedList<LawFirm> getsubsidiaries()
    {
        return this.subsidiaries;
    }

    public ArrayList<Client> getClients()
    {
        return this.clients;
    }

    public ArrayList<Case> getCases()
    {
        return this.cases;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public void setSubsidiaries(LinkedList<LawFirm> newSubsidiaries)
    {
        this.subsidiaries = newSubsidiaries;
    }
    



    public void addEmployee(Employee employee) throws ClosedLawFirmException
    {
        if (!isOpen)
        {
            throw new ClosedLawFirmException(name);
        }

        if (employee instanceof Lawyer)
        {
            this.lawyers.add((Lawyer) employee);
        }

        else if (employee instanceof Secretary)
        {
            this.secretaries.add((Secretary) employee);
        }
    }

    public String toString()
    {
        String lawyerList = lawyers.toString();
        String secretaryList = secretaries.toString();
        return("Law firm " + this.name + ":\n"
                + lawyerList
                + "\n"
                + secretaryList);
    }

    public ArrayList<Lawyer> getLawyersByLicenseType(LicenseType type)
    {
        ArrayList<Lawyer> toRet = new ArrayList<Lawyer>();
        Predicate<Lawyer> pred = (Lawyer current) -> current.getLicense().getType().equals(type);
        for (Lawyer lawyer : lawyers) 
        {
            if (pred.test(lawyer))
            {
                toRet.add(lawyer);
            }
        }

        return toRet;
    }
    
    public void listPlans(int hours)
    {
        LOGGER.info("The costs of a " + hours + " hour plan for all lawyers in " + name + " are:\n");

        if (lawyers.size() == 0)
        {
            LOGGER.info("No lawyers in law firm " + name);
        }

        else
        {
            for (Lawyer lawyer: lawyers) 
            {
                double base = lawyer.getPlan().getBaseCost();
                double hourRate = lawyer.getPlan().getHourRate();
                LOGGER.info(lawyer.getFirstName() + " " + lawyer.getLastName() + ":");
                LOGGER.info("Base rate of " + base + ", plus hourly rate of " + hourRate);
                double total = (base + (hourRate * hours));

                if (lawyer.getSecretary() != null)
                {
                    Secretary secretary = lawyer.getSecretary();
                    if (secretary.getWorkList().size() > 0)
                    {
                        LOGGER.info(secretary.toString() + " has to complete a number of tasks. This may affect waiting times.");
                    }
                }
                
                LOGGER.info("Total: " + total + "\n");
            }
        }
    }    

    public void printCosts(Client client, Logger logger) throws NoCasesFoundException
    {
        if (client.getCases().size() == 0)
        {
            throw new NoCasesFoundException(client.getFirstName().concat(" " + client.getLastName()));
        }

        else
        {
            logger.info("Listing costs for all cases for client " + client.getFirstName() + " " + client.getLastName() + ":\n");
            ArrayList<Integer> caseDurations = new ArrayList<Integer>();

            for (Case c : client.getCases())
            {
                caseDurations.add(c.getDuration());
            }
    
            for (Integer i : caseDurations)
            {
                int index = caseDurations.indexOf(i);
                logger.info("Case " + client.getCases().get(index).getTitle() + ":");
                this.listPlans(i);
                logger.info("----------------------\n");
            }
        }
    }

    public void closeDown()
    {
        LOGGER.info("Law firm " + name + " is being shut down by the government.");

        isOpen = false;
        name = name.concat("(Now closed.)");
        clients.clear();

        for (Lawyer lawyer: lawyers) 
        {
            lawyer.fire();
        }

        for (Secretary secretary : secretaries)
        {
            secretary.fire();
        }

        cases.clear();
    }
}
