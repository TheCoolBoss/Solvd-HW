package com.hw2;
import java.util.ArrayList;

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


    public void printCosts(LawFirm firm) throws NoCasesFoundException
    {
        if (this.cases.size() == 0)
        {
            throw new NoCasesFoundException(firstName.concat(" " + lastName));
        }

        else
        {
            System.out.println("Listing costs for all cases for " + firstName + " " + lastName + ":\n");
            ArrayList<Integer> caseDurations = new ArrayList<Integer>();

            for (Case c : this.cases)
            {
                caseDurations.add(c.getDuration());
            }
    
            for (Integer i : caseDurations)
            {
                int index = caseDurations.indexOf(i);
                System.out.println("Case " + cases.get(index).getTitle() + ":");
                firm.listPlans(i);
                System.out.println("----------------------\n");
            }
        }
    }
}
