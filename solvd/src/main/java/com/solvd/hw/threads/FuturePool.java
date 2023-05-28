package com.solvd.hw.threads;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FuturePool 
{
    private static final int MAX_CONNS = 5;
    private static final Logger LOGGER = LogManager.getLogger("Future Pool");
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(MAX_CONNS);

    private ArrayList<Future<String>> activeConns;
    private ArrayList<Future<String>> idleConns;

    public FuturePool()
    {
        activeConns = new ArrayList<Future<String>>();
        idleConns = new ArrayList<Future<String>>();

        for (int i = 0; i < MAX_CONNS; i++)
        {
            activeConns.add(new FutureVersion().printTest(MainThreads.WORD_LIST[i]));
        }
    }


    public synchronized Future<String> getConn()
    {
        if (activeConns.size() == 0)
        {
            LOGGER.error("No conns to get. :(");
            return null;
        }

        while (!activeConns.get(0).isDone())
        {
            LOGGER.info("Getting connection.");
            try
            {
                Thread.sleep(2000);
            }

            catch (InterruptedException ie)
            {
                LOGGER.error(ie.getMessage());
            }

        }

        Future<String> temp = activeConns.remove(0);
        idleConns.add(temp);
        notifyAll();
        return temp;
    }

    public synchronized void resetConn(Future<String> conn)
    {
        if (conn == null)
        {
            LOGGER.error("Null connection :(");
        }

        else if (!idleConns.contains(conn))
        {
            LOGGER.error("Couldn't find connection. :(");
        }

        else
        {
            idleConns.remove(conn);
            activeConns.add(conn);
        }
    }

    public void addFuture(Future<String> future)
    {
        // if (activeConns.size() > MAX_CONNS)
        // {
        //     try
        //     {
        //         wait();
        //     }

        //     catch (InterruptedException ie)
        //     {
        //         LOGGER.error(ie.getMessage());
        //     }
        // }

        activeConns.add(future);
    }
}
