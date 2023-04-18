package com.hw2;
public class Secretary 
{
    private String firstName;
    private String lastName;
    private Lawyer lawyer;    

    public Secretary(String firstName, String lastName, Lawyer lawyer)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lawyer = lawyer;
    }

    public Secretary(Lawyer lawyer)
    {
        this.firstName = "John";
        this.lastName = "Doe";
        this.lawyer = lawyer;
    }


    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public Lawyer getLawyer()
    {
        return this.lawyer;
    }

    public void setFirstName(String newFirstName)
    {
        this.firstName = newFirstName;
    }

    public void setLastName(String newLastName)
    {
        this.lastName = newLastName;
    }

    public void setLawyer(Lawyer newLawyer)
    {
        this.lawyer = newLawyer;
    }
}
