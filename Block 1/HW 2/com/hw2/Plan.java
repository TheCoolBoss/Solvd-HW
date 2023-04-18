package com.hw2;
public class Plan 
{
    private double baseCost;
    private double extraHourlyRate;    

    public Plan(double base, double hourRate)
    {
        this.baseCost = base;
        this.extraHourlyRate = hourRate;
    }

    public Plan(double hourRate)
    {
        this.baseCost = 0.0;
        this.extraHourlyRate = hourRate;
    }

    
    public double getBaseCost()
    {
        return this.baseCost;
    }

    public double getHourRate()
    {
        return this.extraHourlyRate;
    }

    public void setBaseCost(double newCost)
    {
        this.baseCost = newCost;
    }

    public void setHourRate(double newRate)
    {
        this.extraHourlyRate = newRate;
    }
}
