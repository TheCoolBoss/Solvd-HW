package com.solvd.hw.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.*;

public class MainThreads 
{
    private static final Logger LOGGER = LogManager.getLogger("Thread main");

    public static void main(String[] args)
    {
        RunnableThread run1 = new RunnableThread("Show");
        RunnableThread run2 = new RunnableThread("me");
        RunnableThread run3 = new RunnableThread("your");
        RunnableThread run4 = new RunnableThread("moves");
        RunnableThread run5 = new RunnableThread("!");

        ExtendedThread ext1 = new ExtendedThread("Come");
        ExtendedThread ext2 = new ExtendedThread("on");

        ExecutorService execs = Executors.newFixedThreadPool(5);

        execs.execute(run1);
        execs.execute(run2);
        execs.execute(run3);
        execs.execute(run4);
        execs.execute(run5);
        execs.execute(ext1);
        execs.execute(ext2);

        execs.shutdown();

        while (!execs.isTerminated())
        {
            //Would consider logging, but it might be a huge wall of text
        }

        LOGGER.info("Done");

        Future<String> future1 = new FutureVersion().printTest("Show");
        Future<String> future2 = new FutureVersion().printTest("me");
        Future<String> future3 = new FutureVersion().printTest("your");
        Future<String> future4 = new FutureVersion().printTest("moves");
        Future<String> future5 = new FutureVersion().printTest("!");

        while (!(future1.isDone() && future2.isDone() && future3.isDone() && future4.isDone() && future5.isDone()))
        {
            LOGGER.info("Getting info...");
            try 
            {
                Thread.sleep(1000);
            } 
            
            catch (InterruptedException ie) 
            {
                LOGGER.error(ie.getMessage());
            }
        }

        
        try
        {
            LOGGER.info(future1.get());
            LOGGER.info(future2.get());
            LOGGER.info(future3.get());
            LOGGER.info(future4.get());
            LOGGER.info(future5.get());
        }

        catch (InterruptedException ie)
        {
            LOGGER.error(ie.getMessage());
        } 
        catch (ExecutionException ee) 
        {
            LOGGER.error(ee.getMessage());
        }

        System.exit(0);
    }
}
