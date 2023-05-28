package com.solvd.hw.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CustomPool 
{
    private static final int MAX_CONNS = 5;
    private static final Logger LOGGER = LogManager.getLogger("Connection Pool");
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(MAX_CONNS);
    public ArrayList<CustomConnection> activeConns;
    private ArrayList<CustomConnection> idleConns;


    public CustomPool()
    {
        this.activeConns = new ArrayList<CustomConnection>();
        this.idleConns = new ArrayList<CustomConnection>();
        
        for (int i = 0; i < MAX_CONNS; i++)
        {
            this.activeConns.add(new CustomConnection());
        }
    }

    public synchronized CustomConnection getConn()
    {
        if (activeConns.size() == 0)
        {
            LOGGER.error("No conns to get. :(");
            return null;
        }

        CustomConnection temp = activeConns.remove(0);
        idleConns.add(temp);
        notifyAll();
        return temp;
    }

    public synchronized void resetConn(CustomConnection conn)
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

    public void addConn(CustomConnection conn)
    {
        activeConns.add(conn);
    }
}
