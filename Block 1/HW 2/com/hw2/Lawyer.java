package com.hw2;

import java.util.ArrayList;

public class Lawyer extends Employee
{
    private Plan plan;
    private License license;
    private Secretary secretary;
    private ArrayList<Case> cases;

    public Lawyer(String firstName, String lastName, Plan plan, License license, Secretary secretary)
    {
        super(firstName, lastName);
        this.plan = plan;
        this.license = license;
        this.secretary = secretary;
        this.cases = new ArrayList<Case>();
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


    public void addCase(Case caseToAdd)
    {
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

        //For the purposes of this assignment, I don't think name is as important as license/plan
        if (this.license.getType().equals(temp.license.getType()) && this.plan.toString().equals(temp.plan.toString()))
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
        String caseList = listCases();
        System.out.println("List of cases for lawyer " + getFirstName() + " " + getLastName() + ":\n"
                            + caseList);
    }
}
