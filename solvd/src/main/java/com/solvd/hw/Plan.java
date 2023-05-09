package com.solvd.hw;

import com.solvd.hw.exceptions.*;
import com.solvd.hw.interfaces.*;

public class Plan implements Taxable
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

    //Rate is percent to add on
    //I.e. a rate of 5 indicates the new rate being 105% of the old one
    public void addTax(double rate) throws InvalidTaxRateException
    {
        if (rate < 5.0)
        {
            throw new InvalidTaxRateException("Rate is lower than 5%");
        }

        else if (rate > 10.0)
        {
            throw new InvalidTaxRateException("Rate is larger than 10%");
        }
        
        System.out.println("Plan is being taxed with a rate of " + rate + ".");
        baseCost *= 1 + (rate * 0.01);
        extraHourlyRate *= 1 + (rate * 0.01);
    }
}
