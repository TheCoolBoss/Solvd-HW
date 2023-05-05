package com.hw2.Exceptions;

public class ClosedLawFirmException extends Exception
{
    public ClosedLawFirmException(String firm)
    {
        super("Firm " + firm + " has been closed. Cannot perform this action.");
    }    
}
