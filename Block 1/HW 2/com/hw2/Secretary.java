package com.hw2;
import java.util.ArrayList;

public class Secretary extends Employee
{
    private ArrayList<String> workList;  

    public Secretary(String firstName, String lastName)
    {
        super(firstName, lastName);
        this.workList = new ArrayList<String>();
    }


    public void addWork(String workInfo)
    {
        this.workList.add(workInfo);
    }

    public void removeWork(String workInfo)
    {
        if (!this.workList.contains(workInfo))
        {
            System.out.println(workInfo + " is not in the specified work list.");
        }
        else
        {
            this.workList.remove(workInfo);
        }
    }

    public ArrayList<String> getWorkList()
    {
        return this.workList;
    }

    public void setWorkList(ArrayList<String> newList)
    {
        this.workList = newList;
    }

    public String listAllWork()
    {
        String ret = "";
        for (String work : workList) 
        {
            ret = ret.concat(work.toString() + "\n");
        }

        return ret;
    }

    public String toString()
    {
        return "Secretary " + getFirstName() + " " + getLastName();
    }

    public void printWork()
    {
        System.out.println("List of work for secretary " + firstName + " " + lastName + ":");
        System.out.println(listAllWork());
    }

    public boolean equals(Object toCompare)
    {
        if (toCompare.getClass() != this.getClass())
        {   
            return false;
        }

        Secretary temp = (Secretary) toCompare;
        
        //Not too concerned with work list for this assignment sscope
        if (this.firstName == temp.firstName && this.lastName == temp.lastName)
        {
            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int base = 1;
        base += firstName.length();
        base *= lastName.length();
        return base;
    }
}
