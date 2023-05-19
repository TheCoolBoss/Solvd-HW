package com.solvd.hw.threads;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomPool 
{
    private ArrayList<Thread> allThreads;
    private ArrayList<Thread> currThreads;
    private ExecutorService execs = Executors.newFixedThreadPool(MAX_LEN);
    private static final int MAX_LEN = 5;

    public CustomPool()
    {
        this.currThreads = new ArrayList<Thread>();
        this.allThreads = new ArrayList<Thread>();
    }

    public void execute()
    {
        synchronized(this)
        {
            while (this.allThreads.size() != 0)
            {
                fillThreads();
                for (Thread thread : currThreads) 
                {
                    execs.execute(thread);
                }
                this.currThreads.clear();
            }

            this.execs.shutdown();
        }

    }

    
    public void addThread(Thread thread)
    {
        this.allThreads.add(thread);
    }

    public void fillThreads()
    {
         while (this.currThreads.size() < MAX_LEN)
         {
            if (this.allThreads.size() != 0)
            {
                this.currThreads.add(this.allThreads.get(0));
                this.allThreads.remove(0);
            }

            else
            {
                break;
            }
         }
    }
}
