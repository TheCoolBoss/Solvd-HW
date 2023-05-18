package com.solvd.hw.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunnableThread implements Runnable
{
    private static final Logger LOGGER = LogManager.getLogger("RunnableThread");
    private String toPrint;

    public RunnableThread(String toPrint)
    {
        this.toPrint = toPrint;
    }

    public void run()
    {
        try
        {
            LOGGER.info(toPrint);
            Thread.sleep(3000);
        }

        catch (InterruptedException ie)
        {
            LOGGER.error(ie.getMessage());
        }
    }
}
