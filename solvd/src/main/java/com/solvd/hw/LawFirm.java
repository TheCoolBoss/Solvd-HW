package com.solvd.hw;

import java.util.ArrayList;
import java.util.function.*;
import java.util.stream.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw.enums.Court;
import com.solvd.hw.exceptions.*;
import com.solvd.hw.interfaces.*;
import com.solvd.hw.lambdas.Adders;
import com.solvd.hw.lambdas.interfaces.IFilter;

public class LawFirm implements CanBeShutDown
{
    private static final Logger LOGGER = LogManager.getLogger(LawFirm.class);
    private static final Adders ADDER_LAMBDAS = new Adders();
    private static final BinaryOperator<String> CONCATER = (String s1, String s2) -> s1.concat(s2);
    private static final String COUNTRY = "USA";

    private String name; 
    private ArrayList<Lawyer> lawyers;
    private ArrayList<Secretary> secretaries;
    private ArrayList<Client> clients;
    private ArrayList<Case> cases;
    private LinkedList<LawFirm> subsidiaries;
    private boolean isOpen;
    private Court jurisdiction;

    static
    {
        LOGGER.info("Establishing new law firm in " + COUNTRY + ".");
    }

    public LawFirm(String name, Court jurisdiction)
    {
        this.name = name;
        this.lawyers = new ArrayList<Lawyer>();
        this.clients = new ArrayList<Client>();
        this.secretaries = new ArrayList<Secretary>();
        this.cases = new ArrayList<Case>();
        this.subsidiaries = new LinkedList<LawFirm>();
        this.isOpen = true;
        this.jurisdiction = jurisdiction;
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
    
    public LinkedList<LawFirm> getSubsidiaries()
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

    public String getJurisdiction()
    {
        return this.jurisdiction.name();
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
        return("Law firm of jurisdiction " + jurisdiction + " " + this.name + ":\n"
                + lawyerList
                + "\n"
                + secretaryList);
    }

    public ArrayList<Lawyer> getLawyersByLicenseType(Predicate<Lawyer> condition)
    {
        return (ArrayList<Lawyer>) this.lawyers.stream().filter(condition).collect(Collectors.toList());
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
            lawyers.stream().forEach(lawyer ->
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
            });
        }
    }    

    public void printCases()
    {
        LOGGER.info(cases.toString());
    }
    
    public void printCosts(Client client, Logger logger) throws NoCasesFoundException
    {
        if (client.getCases().size() == 0)
        {
            throw new NoCasesFoundException(CONCATER.apply(client.getFirstName(), " " + client.getLastName()));
        }

        else
        {
            logger.info("Listing costs for all cases for client " + client.getFirstName() + " " + client.getLastName() + ":\n");
            ArrayList<Integer> caseDurations = new ArrayList<Integer>();

            client.getCases().stream().forEach(clientCase ->
            {
                caseDurations.add(clientCase.getDuration());
            });

            caseDurations.stream().forEach(i ->
            {
                int index = caseDurations.indexOf(i);
                logger.info("Case " + client.getCases().get(index).getTitle() + ":");
                this.listPlans(i);
                logger.info("----------------------\n");
            });
        }
    }

    //Adds specified cases of this firm to a specified lawyer's case list
    //Not terribly concerned about doing this for clients since I doubt one client is on every single case at most times
    public void addCasesToLawyer(ArrayList<Case> caseList, Lawyer recipient)
    {
        ADDER_LAMBDAS.caseAdder.add(caseList, recipient.getCases());
    }

    public ArrayList<Case> filterCasesByName(IFilter<Case> nameFilter)
    {
        return nameFilter.filter(cases);
    }


    public void closeDown()
    {
        LOGGER.info("Law firm " + name + " is being shut down by the government.");

        isOpen = false;
        CONCATER.apply(name, " (Now closed)");
        clients.clear();

        lawyers.stream().forEach(lawyer -> lawyer.fire());
        secretaries.stream().forEach(secretary -> secretary.fire());
        cases.clear();
    }
}
