package com.solvd.hw.reflection;

import java.lang.reflect.*;
import com.solvd.hw.LawFirm;
import com.solvd.hw.enums.Court;

public class ReflectionTest 
{
    public static void main(String[] args)
    {
        try 
        {
            Class<?> test = Class.forName("com.solvd.hw.LawFirm");
            Constructor<?>[] consts = test.getDeclaredConstructors();
            Method[] methods = test.getDeclaredMethods();
            System.out.println("Name " + test.getName());

            for (Constructor<?> constructor : consts) 
            {
                System.out.println("Constructor " + constructor);
                System.out.println(constructor.getParameterTypes());
            }
            
            for (Method method: methods)
            {
                System.out.println("Method " + method.getName());
            }

            try
            {
                LawFirm firmReflect = (LawFirm) consts[0].newInstance("Reflection Firm", Court.FEDERAL);
                for (Method method : methods) 
                {
                    if (method.getName().equals("toString"))
                    {
                        System.out.println(method.invoke(firmReflect));
                    }
                }
            }

            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }


            
        } 
        
        catch (ClassNotFoundException cnfe) 
        {
            System.out.println(cnfe.getMessage());
        }


    }


}
