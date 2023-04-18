package com.hw2;
public class LawyerRemote extends Lawyer
{
    private String timeZone;

    public LawyerRemote(String firstName, String lastName, Plan plan, License license)
    {
        super(firstName, lastName, plan, license);
    }

    public LawyerRemote(Plan plan, License license)
    {
        super(plan, license);
    }


    public String getTimeZone()
    {
        return this.timeZone;
    }

    public void setTimeZone(String newZone)
    {
        this.timeZone = newZone;
    }
}
