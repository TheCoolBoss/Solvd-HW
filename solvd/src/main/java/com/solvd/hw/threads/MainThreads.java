package com.solvd.hw.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainThreads 
{
    //Public so that connection class can reference it
    public static final String[] WORD_LIST = {"Show", "me", "your", "moves", "!", "Come", "on"};
    private static final int MAX_CONNS = 5;
    private static final Logger LOGGER = LogManager.getLogger("Thread main");
    private static ExecutorService execs = Executors.newFixedThreadPool(MAX_CONNS);

    public static void main(String[] args)
    {
        CustomPool pool = new CustomPool();
        FuturePool futurePool = new FuturePool();


        CustomConnection newConn1 = new CustomConnection();
        CustomConnection newConn2 = new CustomConnection();

        pool.addConn(newConn1);
        pool.addConn(newConn2);

        for (int i = 0; i < MAX_CONNS + 2; i++) 
        {
            CustomConnection conn = pool.getConn();
            execs.execute(conn.thread);
            pool.resetConn(conn);
        }
        

        try
        {
            Thread.sleep(2000);
        }

        catch (InterruptedException ie)
        {
            LOGGER.error(ie.getMessage());
        }


        //2 new threads to add
        Future<String> extraFuture1 = new FutureVersion().printTest(WORD_LIST[5]);
        Future<String> extraFuture2 = new FutureVersion().printTest(WORD_LIST[6]);

        
        futurePool.addFuture(extraFuture1);
        futurePool.addFuture(extraFuture2);

        for (int i = 0; i < MAX_CONNS + 2; i++)
        {
            try
            {

                Future<String> future = futurePool.getConn();
                LOGGER.info(future.get());
                futurePool.resetConn(future);

            }

            catch (InterruptedException | ExecutionException e)
            {
                LOGGER.error(e.getMessage());
            }
        }








        execs.shutdown();
        System.exit(0);
    }
}
