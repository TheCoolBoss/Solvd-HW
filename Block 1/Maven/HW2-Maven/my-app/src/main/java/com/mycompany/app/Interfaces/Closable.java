package com.mycompany.app.Interfaces;

import org.apache.logging.log4j.Logger;

public interface Closable 
{
    void close(Logger logger);
    void reOpen(Logger logger);
}
