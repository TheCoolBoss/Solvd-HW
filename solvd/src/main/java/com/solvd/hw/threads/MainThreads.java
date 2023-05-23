package com.solvd.hw.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainThreads 
{
    private static final Logger LOGGER = LogManager.getLogger("Thread main");
    private static ExecutorService execs = Executors.newFixedThreadPool(5);

    public static void main(String[] args)
    {
        CustomPool pool = new CustomPool();

        ExtendedThread run1 = new ExtendedThread("Show");
        ExtendedThread run2 = new ExtendedThread("me");
        ExtendedThread run3 = new ExtendedThread("your");
        ExtendedThread run4 = new ExtendedThread("moves");
        ExtendedThread run5 = new ExtendedThread("!");

        ExtendedThread ext1 = new ExtendedThread("Come");
        ExtendedThread ext2 = new ExtendedThread("on");


        pool.addThread(run1);
        pool.addThread(run2);
        pool.addThread(run3);
        pool.addThread(run4);
        pool.addThread(run5);
        pool.addThread(ext1);
        pool.addThread(ext2);

        for (int i = 0; i < 7; i++) 
        {
            execs.execute(pool.getConn());
        }

        execs.shutdown();

        LOGGER.info("Done");


        String[] list = {"Show", "me", "your", "moves", "!", "Come", "on"};

        for (String string : list) 
        {
            pool.addFuture(string);
        }

        System.exit(0);
    }
}
