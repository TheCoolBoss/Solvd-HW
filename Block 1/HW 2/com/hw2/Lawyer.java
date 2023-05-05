package com.hw2;

import java.util.ArrayList;

import com.hw2.Exceptions.InvalidLicenseException;
import com.hw2.Interfaces.CanBeFired;
import org.apache.logging.log4j.Logger;

public class Lawyer extends Employee implements CanBeFired
{
    private Plan plan;
    private License license;
    private Secretary secretary;
    private ArrayList<Case> cases;

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

    public String listCases()
    {
        String ret = "";
        for (Case c : cases) 
        {
            ret = ret.concat(c.toString() + "\n");
        }

        return ret;
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

    public void printWork(Logger logger)
    {
        String caseList = listCases();
        logger.info("List of cases for lawyer " + getFirstName() + " " + getLastName() + ":\n"
                            + caseList);
    }

    public void fire(Logger logger)
    {
        logger.info("Lawyer " + firstName + " " + lastName + " has been fired!");
        this.plan = null;
        this.secretary = null;
        this.salary = 0.0;
        this.id = -1;
        this.cases.clear();
        this.license.revoke();
    }
}
