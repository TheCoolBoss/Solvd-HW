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

    public String toString()
    {
        return "Plan rate has base cost of " + baseCost + " and an hourly rate of " + extraHourlyRate + ".";
    }

    public boolean equals(Object toCompare)
    {
        if (toCompare.getClass() != this.getClass())
        {   
            return false;
        }

        Plan temp = (Plan) toCompare;
        
        if (this.getBaseCost() == temp.getBaseCost() && this.getHourRate() == temp.getHourRate())
        {
            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int base = 100;
        base += baseCost;
        return base;
    }
}
