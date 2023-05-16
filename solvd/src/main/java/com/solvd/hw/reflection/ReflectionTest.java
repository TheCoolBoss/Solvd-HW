package com.solvd.hw.reflection;

import java.lang.reflect.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw.LawFirm;
import com.solvd.hw.enums.Court;

public class ReflectionTest 
{
    private static final Logger LOGGER = LogManager.getLogger(ReflectionTest.class);

    public static void main(String[] args)
    {
        try 
        {
            Class<?> test = Class.forName("com.solvd.hw.LawFirm");
            Class<?>[] params = {String.class, Court.class};

            LOGGER.info("Name " + test.getName());

            //Should probably change this to make constructor some hard coded one on exception, but focusing on other stuff right now
            try
            {
                Constructor<?> constructor = test.getDeclaredConstructor(params);
                Method[] methods = test.getDeclaredMethods();
    
                LOGGER.info("Constructor " + constructor);
                
                for (Method method: methods)
                {
                    LOGGER.info("Method " + method.getName());
                }
    
                try
                {
                    LawFirm firmReflect = (LawFirm) constructor.newInstance("Reflection Firm", Court.FEDERAL);
                    for (Method method : methods) 
                    {
                        if (method.getName().equals("toString"))
                        {
                            LOGGER.info("Calling toString");
                            LOGGER.info(method.invoke(firmReflect));
                        }
                    }
                }
    
                catch (Exception e)
                {
                    LOGGER.info(e.getMessage());
                }
            }

            catch (NoSuchMethodException nsme)
            {
                LOGGER.error("Constructor not found :(");
            }           
        } 
        
        catch (ClassNotFoundException cnfe) 
        {
            LOGGER.info(cnfe.getMessage());
        }
    }
}
