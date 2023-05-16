package com.solvd.hw;

import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw.enums.SecretaryWork;
import com.solvd.hw.interfaces.*;
import com.solvd.hw.lambdas.Sorters;

public class Secretary extends Employee implements CanBeFired
{
    private static final BinaryOperator<String> CONCATER = (String s1, String s2) -> s1.concat(s2);
    private static final Logger LOGGER = LogManager.getLogger(Secretary.class);
    private static final Function<String, String> NEW_LINE_ADDER = (String caseString) -> caseString.concat("\n");
    private static final Sorters LAMBD_SORTERS = new Sorters();
    private ArrayList<SecretaryWork> workList;  

    public Secretary(String firstName, String lastName, int id, String hireDate)
    {
        super(firstName, lastName);
        this.workList = new ArrayList<SecretaryWork>();
        this.salary = 150.00;
        this.id = id;
        this.dateOfHire = hireDate;
    }


    public void addWork(SecretaryWork work)
    {
        this.workList.add(work);
    }

    public void removeWork(SecretaryWork workToRemove)
    {
        if (workList.contains(workToRemove))
        {
            LOGGER.info("Removing work " + workToRemove.name());
            workList.remove(workToRemove);
        }

        else
        {
            LOGGER.info("Work " + workToRemove.name() + " is not in the specified work list.");
        }

    }

    public ArrayList<SecretaryWork> getWorkList()
    {
        return this.workList;
    }

    public void setWorkList(ArrayList<SecretaryWork> newList)
    {
        this.workList = newList;
    }

    public String toString()
    {
        return "Secretary " + getFirstName() + " " + getLastName();
    }

    public void printWork()
    {
        LOGGER.info("List of work for secretary " + firstName + " " + lastName + ":");

        String workString = "";
        for (SecretaryWork work : workList) 
        {
            workString = CONCATER.apply(workString, NEW_LINE_ADDER.apply(work.name()));
        }

        LOGGER.info(workString);
    }

    public void sortWork()
    {
        LAMBD_SORTERS.secretaryWorkSorter.sort(workList);
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
