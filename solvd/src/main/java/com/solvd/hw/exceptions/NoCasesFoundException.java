package com.solvd.hw.exceptions;

public class NoCasesFoundException extends Exception
{
    public NoCasesFoundException(String client)
    {
        super("There are no cases for client " + client + ".");
    }
}
