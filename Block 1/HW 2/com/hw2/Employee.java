package com.hw2;

public abstract class Employee
{
    protected String firstName;
    protected String lastName;
    protected int id;
    protected String dateOfHire;
    protected double salary;

    public Employee(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public abstract void printWork();

    //Setters for date of hire and id omitted because they don't seem 100% necessary for this type of system
    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public int getId()
    {
        return this.id;
    }

    public String getHireDate()
    {
        return this.dateOfHire;
    }

    public double getSalary()
    {
        return this.salary;
    }

    public void setFirstName(String newFirstName)
    {
        this.firstName = newFirstName;
    }

    public void setLastName(String newLastName)
    {
        this.lastName = newLastName;
    }

    public void setSalary(double newSalary)
    {
        this.salary = newSalary;
    }
}
