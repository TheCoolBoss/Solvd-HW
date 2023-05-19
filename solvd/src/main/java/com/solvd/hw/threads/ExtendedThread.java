package com.solvd.hw.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExtendedThread extends Thread
{
    private static final Logger LOGGER = LogManager.getLogger("ExtendedThread");
    private String toPrint;
    
    public ExtendedThread(String toPrint)
    {
        this.toPrint = toPrint;
    }

    public void run()
    {
        try
        {
            LOGGER.info(toPrint);
            Thread.sleep(1000);
        }

        catch (InterruptedException ie)
        {
            LOGGER.error(ie.getMessage());
        }
    }
}
