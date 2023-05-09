package com.solvd.hw.interfaces;

import com.solvd.hw.exceptions.InvalidTaxRateException;

public interface Taxable 
{
    void addTax(double rate) throws InvalidTaxRateException;    
}
