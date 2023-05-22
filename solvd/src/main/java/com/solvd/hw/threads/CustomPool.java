package com.solvd.hw.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomPool 
{
    private static final Logger LOGGER = LogManager.getLogger("Pool");
    private ArrayList<Runnable> allThreads;
    private ArrayList<Runnable> currThreads;
    private ExecutorService execs = Executors.newFixedThreadPool(MAX_LEN);
    private static final int MAX_LEN = 5;

    public CustomPool()
    {
        this.currThreads = new ArrayList<Runnable>();
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
}
