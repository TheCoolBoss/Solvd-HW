package com.mycompany.app.Interfaces;

import com.mycompany.app.Exceptions.InvalidTaxRateException;

public interface Taxable 
{
    void addTax(double rate) throws InvalidTaxRateException;    
}
