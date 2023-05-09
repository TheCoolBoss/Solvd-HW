package com.solvd.hw.exceptions;

public class InvalidLicenseException extends Exception
{
    public InvalidLicenseException(String lawyer)
    {
        super("License of " + lawyer + " is invalid. Cannot perform requested action.");
    }    
}
