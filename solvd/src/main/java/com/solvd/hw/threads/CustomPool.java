package com.solvd.hw.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CustomPool
{
    private static final Logger LOGGER = LogManager.getLogger("Pool");
    private ArrayList<Runnable> allThreads;

    public CustomPool()
    {
        this.allThreads = new ArrayList<Runnable>();
    }

    public synchronized Runnable getConn()
    {
        if (allThreads.size() == 0)
        {
            try
            {
                wait();
            }

            catch (InterruptedException ie)
            {
                LOGGER.error(ie.getMessage());
            }

        }

        return allThreads.remove(0);
    }

    public void newThread(Runnable thread)
    {
        thread.run();
    }

    public void addThread(Runnable thread)
    {
        this.allThreads.add(thread);
    }

    public synchronized void addFuture(String input)
    {
        String toPrint = "Couldn't get info";
        Future<String> toAdd = new FutureVersion().printTest(input);

        try
        {
            toPrint = toAdd.get();
        }

        catch (InterruptedException | ExecutionException e)
        {
            LOGGER.info(e.getMessage());
        }
        
        LOGGER.info(toPrint);
    }
}
