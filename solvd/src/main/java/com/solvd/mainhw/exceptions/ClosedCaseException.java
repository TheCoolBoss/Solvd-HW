package com.solvd.mainhw.exceptions;

public class ClosedCaseException extends Exception
{
    public ClosedCaseException(String caseName)
    {
        super("Case " + caseName + " is closed. Cannot perform requested action.");
    }
}