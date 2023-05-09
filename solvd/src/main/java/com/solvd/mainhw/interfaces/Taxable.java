package com.solvd.mainhw.interfaces;

import com.solvd.mainhw.exceptions.InvalidTaxRateException;

public interface Taxable 
{
    void addTax(double rate) throws InvalidTaxRateException;    
}
