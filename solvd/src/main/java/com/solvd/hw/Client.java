package com.solvd.hw;

import java.util.ArrayList;
import java.util.Optional;
import com.solvd.hw.lambdas.Sorters;

public class Client 
{
    private static final String DEFAULT_FIRST_NAME = "John";
    private static final String DEFAULT_LAST_NAME = "Doe";
    private String firstName;
    private String lastName;
    private ArrayList<Case> cases;

    public Client(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cases = new ArrayList<Case>();
    }

    public Client()
    {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME); 
    }

    //Get/setters
    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public ArrayList<Case> getCases()
    {
        return this.cases;
    }

    public String getFullName()
    {
        return getFirstName() + " " + getLastName();
    }

    public void setFirstName(String newFirstName)
    {
        this.firstName = newFirstName;
    }

    public void setLastName(String newLastName)
    {
        this.lastName = newLastName;
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

    //Couldn't figure out how to use min since getTotalCostsOfCases uses a param
    //i.e. don't know how to pass dynamic param in a comparator
    public Lawyer getCheapestLawyer(ArrayList<Lawyer> lawyerList)
    {
        double bestCost = lawyerList.get(0).getTotalCostsOfCases(this.cases);
        int index = 0;

        for (int i = 1; i < lawyerList.size(); i++)
        {
            double currCost = lawyerList.get(i).getTotalCostsOfCases(this.cases);
            if (currCost < bestCost)
            {
                bestCost = currCost;
                index = i;
            }
        }

        return lawyerList.get(index);
    }

    public Optional<Lawyer> getFastestLawyer(ArrayList<Lawyer> lawyerList)
    {
        return lawyerList.stream().min(Sorters.LEAST_BUSY_LAWYER);
    }
}
