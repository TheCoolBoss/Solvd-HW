package com.mycompany.app.Exceptions;

public class NoCasesFoundException extends Exception
{
    public NoCasesFoundException(String client)
    {
        super("There are no cases for client " + client + ".");
    }
}
