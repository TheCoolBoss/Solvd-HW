package com.solvd.hw.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomConnection 
{
    private static final Logger LOGGER = LogManager.getLogger("Pool");
    static int currentWordIndex = 0;
    public Runnable thread;

    public CustomConnection()
    {
        this.thread = new RunnableThread(MainThreads.WORD_LIST[currentWordIndex]);

        currentWordIndex++;

        if (currentWordIndex >= MainThreads.WORD_LIST.length)
        {
            currentWordIndex = 0;
        }
    
    }

    public void start()
    {
        LOGGER.info("Starting connection");
        thread.run();
        LOGGER.info("Connection done");
    }
}
