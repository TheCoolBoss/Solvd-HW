package com.hw2;
import java.util.ArrayList;

public class LawFirm 
{
    protected String name; 
    protected ArrayList<Lawyer> lawyers;
    protected ArrayList<Secretary> secretaries;
    protected ArrayList<Client> clients;
    protected ArrayList<Case> cases;

    public LawFirm(String name)
    {
        this.name = name;
        this.lawyers = new ArrayList<Lawyer>();
        this.clients = new ArrayList<Client>();
        this.secretaries = new ArrayList<Secretary>();
        this.cases = new ArrayList<Case>();
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
    

    public String getInfoAsList(String type, ArrayList list)
    {
        String toRet = type + ":\n";
        for (Object item : list) 
        {
            toRet = toRet.concat(item.toString() + "\n");
        }

        return toRet;
    }

    public String toString()
    {
        String lawyerList = getInfoAsList("Lawyers", lawyers);
        String secretaryList = getInfoAsList("Secretaries", secretaries);
        return("Law firm " + this.name + ":\n"
                + lawyerList
                + "\n"
                + secretaryList);
    }


    public void areThereClients()
    {
        if (this.clients.size() > 0)
        {
            System.out.println("The client list is not empty. You will have to wait. :(");
        }
    }

    public void listPlans(int hours)
    {
        System.out.println("The costs of a " + hours + " hour plan for all lawyers in " + name + " are:");
        for (Lawyer lawyer: lawyers) 
        {
            double base = lawyer.getPlan().getBaseCost();
            double hourRate = lawyer.getPlan().getHourRate();
            System.out.println(lawyer.getFirstName() + " " + lawyer.getLastName() + ":");
            System.out.println("Base rate of " + base + ", plus hourly rate of " + hourRate);
            double total = (base + (hourRate * hours));
            System.out.println("Total: " + total);
        }
    }    
}
