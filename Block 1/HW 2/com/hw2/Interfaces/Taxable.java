package com.hw2.Interfaces;
import com.hw2.Exceptions.InvalidTaxRateException;

public interface Taxable 
{
    void addTax(double rate) throws InvalidTaxRateException;    
}
