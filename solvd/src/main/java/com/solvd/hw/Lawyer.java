package com.solvd.hw;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.function.*;
import com.solvd.hw.enums.Session;
import com.solvd.hw.exceptions.*;
import com.solvd.hw.interfaces.*;
import com.solvd.hw.lambdas.*;

public class Lawyer extends Employee implements CanBeFired
{
    private static final Logger LOGGER = LogManager.getLogger(Lawyer.class);
    private static final Sorters SORTER_LAMBDAS = new Sorters();
    private final Function<String, String> NEW_LINE_ADDER = (String caseString) -> caseString.concat("\n");

    private Plan plan;
    private License license;
    private Secretary secretary;
    private ArrayList<Case> cases;
    private ArrayList<Session> sessions;

    public Lawyer(String firstName, String lastName, Plan plan, License license, Secretary secretary, String hireDate, int id)
    {
        super(firstName, lastName);
        this.plan = plan;
        this.license = license;
        this.secretary = secretary;
        this.cases = new ArrayList<Case>();
        this.dateOfHire = hireDate;
        this.salary = 200.00;
        this.id = id;
        this.sessions = new ArrayList<Session>();
    }

    
    public Plan getPlan()
    {
        return this.plan;
    }

    public License getLicense()
    {
        return this.license;
    }

    public Secretary getSecretary()
    {
        return this.secretary;
    }

    public ArrayList<Case> getCases()
    {
        return this.cases;
    }

    public void setPlan(Plan newPlan)
    {
        this.plan = newPlan;
    }

    public void setLicense(License newLicense)
    {
        this.license = newLicense;
    }

    public void setSecretary(Secretary newSecretary)
    {
        this.secretary = newSecretary;
    }

    public void setCases(ArrayList<Case> newCases)
    {
        this.cases = newCases;
    }

    public ArrayList<Session> getSessions()
    {
        return this.sessions;
    }

    public void addSession(Session toAdd)
    {
        this.sessions.add(toAdd);
    }

    public void removeSession(Session toRem)
    {
        this.sessions.remove(toRem);
    }
    
    public void addCase(Case caseToAdd) throws InvalidLicenseException
    {
        if (!license.getStatus())
        {
            throw new InvalidLicenseException(firstName.concat(" " + lastName));
        }
        this.cases.add(caseToAdd);
    }

    public void removeCase(Case caseToRemove)
    {
        this.cases.remove(caseToRemove);
    }
    
    //The param is added in the event cases beyond this lawyer's list want to be included
    public double getTotalCostsOfCases(ArrayList<Case> cases)
    {
        double total = 0.0;

        for (Case c : cases) 
        {
            total += this.getPlan().getBaseCost() + (this.getPlan().getHourRate() * c.getDuration());
        }

        return total;
    }

    public String toString()
    {
        return "Lawyer " + getFirstName() + " " + getLastName();
    } 

    public boolean equals(Object toCompare)
    {
        if (toCompare.getClass() != this.getClass())
        {   
            return false;
        }

        Lawyer temp = (Lawyer) toCompare;

        //For the purposes of this assignment, I don't think name and other fields are as important as license/plan
        if (this.license.getType().equals(temp.license.getType()) 
            && this.plan.toString().equals(temp.plan.toString())
            && this.id == temp.id
            && this.dateOfHire.equals(temp.dateOfHire)
            && this.salary == temp.salary)
        {
            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int base = 7;
        base *= cases.size();
        return base;
    }

    public void printWork()
    {
        String caseList= "";

        for (Case c : this.cases) 
        {
            caseList = caseList.concat(NEW_LINE_ADDER.apply(c.getTitle()));
        }

        LOGGER.info("List of cases for lawyer " + getFirstName() + " " + getLastName() + ":\n"
                            + caseList);
    }

    public void fire()
    {
        LOGGER.info("Lawyer " + firstName + " " + lastName + " has been fired!");
        this.plan = null;
        this.secretary = null;
        this.salary = 0.0;
        this.id = -1;
        this.cases.clear();
        this.license.revoke();
    }

    public void sortWork()
    {
        SORTER_LAMBDAS.caseNameSorter.sort(cases);
    }
}
