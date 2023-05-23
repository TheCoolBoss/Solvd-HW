package com.solvd.hw.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureVersion 
{
    private ExecutorService executor = Executors.newSingleThreadExecutor();
     public Future<String> printTest(String input)
     {
        return executor.submit(() ->
        {
            Thread.sleep(500);
            return "Printed " + input;
        });
     }
}
