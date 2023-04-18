package com.hw2;
import java.util.ArrayList;

public class LawFirm 
{
    public String name; 
    public ArrayList<Lawyer> lawyers;
    public ArrayList<Secretary> secretaries;
    public ArrayList<Client> clients;
    public ArrayList<Case> cases;

    public LawFirm(String name)
    {
        this.name = name;
        this.lawyers = new ArrayList<Lawyer>();
        this.clients = new ArrayList<Client>();
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }
    
    public void areThereClients()
    {
        if (this.clients.size() > 0)
        {
            System.out.println("The client list is not empty. You will have to wait. :(");
        }
    }

    
}
