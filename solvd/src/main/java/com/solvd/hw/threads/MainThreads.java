package com.solvd.hw.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.*;

public class MainThreads 
{
    private static final Logger LOGGER = LogManager.getLogger("Thread main");

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
        pool.execute();

        LOGGER.info("Done");







        // Future<String> future1 = new FutureVersion().printTest("Show");
        // Future<String> future2 = new FutureVersion().printTest("me");
        // Future<String> future3 = new FutureVersion().printTest("your");
        // Future<String> future4 = new FutureVersion().printTest("moves");
        // Future<String> future5 = new FutureVersion().printTest("!");

    }
}
