package com.solvd.hw.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CustomPool
{
    private static final Logger LOGGER = LogManager.getLogger("Pool");
    private static ExecutorService execs = Executors.newFixedThreadPool(5);
    private ArrayList<Runnable> allThreads;
    private ArrayList<Future<String>> allFutures;

    public CustomPool()
    {
        this.allThreads = new ArrayList<Runnable>();
        this.allFutures = new ArrayList<Future<String>>();
    }

    public Runnable getConn()
    {
        if (allThreads.size() == 0)
        {
            try
            {
                wait(5000);
            }

            catch (InterruptedException ie)
            {
                LOGGER.error(ie.getMessage());
                return new RunnableThread(ie.getMessage());
            }

        }


        //LOGGER.info(execs.submit(allThreads.get(0)).get());
        return allThreads.remove(0);
    }



    public void addThread(Runnable thread)
    {
        this.allThreads.add(thread);
    }


    //Future stuff
    public String getFuture()
    {
        String toRet = "Nothing :(";

        if (allFutures.size() != 0)
        {
            try
            {
                toRet = allFutures.get(0).get();
                allFutures.remove(0);
            }
    
            catch (InterruptedException | ExecutionException e)
            {
                LOGGER.info(e.getMessage());
            }
        }

        return toRet;
    }

    public void addFuture(String input)
    {
        allFutures.add(new FutureVersion().printTest(input));
    }
}
