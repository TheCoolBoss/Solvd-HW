package com.mycompany.app.Exceptions;

public class InvalidTaxRateException extends Exception
{
    public InvalidTaxRateException(String error)
    {
        super(error);
    }
   
}
