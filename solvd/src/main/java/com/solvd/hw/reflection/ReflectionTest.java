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

            LOGGER.info("Class " + test.getSimpleName() + "\n");            

            printFields(test);
            LOGGER.info("\n");
            printConstructors(test);
            LOGGER.info("\n");
            printMethods(test);

            try
            {
                Constructor<?> testConst = test.getDeclaredConstructor(params);
                LawFirm firmReflect = (LawFirm) testConst.newInstance("Reflection Firm", Court.FEDERAL);
                Method getString = test.getDeclaredMethod("toString");

                LOGGER.info("Calling toString");
                LOGGER.info(getString.invoke(firmReflect));
            }

            catch (Exception e)
            {
                LOGGER.info(e.getMessage());
            }
                   
        } 
        
        catch (ClassNotFoundException cnfe) 
        {
            LOGGER.info(cnfe.getMessage());
        }
    }



    public static void printFields(Class<?> toPrint)
    {
        Field[] fields = toPrint.getDeclaredFields();
        for (Field field : fields) 
        {
            LOGGER.info("Field " + field.getType().getSimpleName() + " " + field.getName() + " has modifier " + field.getModifiers());
        }
    }



    public static void printConstructors(Class<?> toPrint)
    {
        Constructor<?>[] constList = toPrint.getDeclaredConstructors();
        
        for (Constructor<?> constructor : constList) 
        {
            LOGGER.info("Constructor " + constructor.getName() + " has modifier " + constructor.getModifiers());
            LOGGER.info(printParams(constructor.getParameterTypes()));
            LOGGER.info("----------\n");
        }
    }



    public static void printMethods(Class<?> toPrint)
    {
        Method[] methods = toPrint.getMethods();
        for (Method method: methods)
        {
            LOGGER.info("Method " + method.getName() + " has modifier " + method.getModifiers());
            LOGGER.info(printParams(method.getParameterTypes()));

            LOGGER.info("Returns " + method.getReturnType());
            LOGGER.info("-------------\n");
        }
    }

    public static String printParams(Class<?>[] paramList)
    {
        if (paramList.length == 0)
        {
            return "No parameters";
        }

        String paramsAsString = "Parameters: ";
        for (Class<?> paramType : paramList) 
        {
            paramsAsString = paramsAsString.concat(paramType.getSimpleName() + ", ");    
        }

        //Remove last comma
        paramsAsString = paramsAsString.substring(0, paramsAsString.length() - 2);
        
        return paramsAsString;
    }
}
