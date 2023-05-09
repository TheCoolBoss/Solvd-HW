package com.solvd.hw;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.hw.interfaces.*;

public class Secretary extends Employee implements CanBeFired
{
    private static final Logger LOGGER = LogManager.getLogger(Secretary.class);
    private ArrayList<String> workList;  

    public Secretary(String firstName, String lastName, int id, String hireDate)
    {
        super(firstName, lastName);
        this.workList = new ArrayList<String>();
        this.salary = 150.00;
        this.id = id;
        this.dateOfHire = hireDate;
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
        LOGGER.info("List of work for secretary " + firstName + " " + lastName + ":");
        LOGGER.info(listAllWork());
    }

    public boolean equals(Object toCompare)
    {
        if (toCompare.getClass() != this.getClass())
        {   
            return false;
        }

        Secretary temp = (Secretary) toCompare;
        
        //Not too concerned with work list for this assignment sscope
        if (this.firstName == temp.firstName 
            && this.lastName == temp.lastName
            && this.id == temp.id
            && this.salary == temp.salary
            && this.dateOfHire.equals(temp.dateOfHire))
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

    public void fire()
    {
        LOGGER.info("Secretary " + firstName + " " + lastName + " has been fired!");
        this.workList.clear();
        this.workList = null;
        this.salary = 0.0;
        this.id = -1; 
    }
}
