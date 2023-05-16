package com.solvd.hw;

import com.solvd.hw.enums.Timezone;

public class LawyerRemote extends Lawyer
{
    private Timezone timeZone;

    public LawyerRemote(String firstName, String lastName, Plan plan, License license, Secretary secretary, String hireDate, int id, Timezone zone)
    {
        super(firstName, lastName, plan, license, secretary, hireDate, id);
        this.timeZone = zone;
    }

    public String getTimeZone()
    {
        return this.timeZone.name();
    }

    public void setTimeZone(Timezone newZone)
    {
        this.timeZone = newZone;
    }
}
