package com.hw2.Interfaces;
import org.apache.logging.log4j.Logger;

public interface Closable 
{
    void close(Logger logger);
    void reOpen(Logger logger);
}
