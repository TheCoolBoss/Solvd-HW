package com.solvd.hwold;

public class Sorter 
{
    public static void main(String[] args)
    {
        //Bubble sort
        int[] arr = new int[args.length];
        for (int i = 0; i < args.length; i++) 
        {
            try 
            {
                arr[i] = Integer.parseInt(args[i]);
            } 
            catch (NumberFormatException nfe) 
            {
                System.out.println("Can't convert " + args[i] + " to an int. Defaulting to 0. :(");
                arr[i] = 0;
            }
            
        }
        boolean done = false;

        while (!done)
        {
            boolean hasSwapped = false;
            for (int i = 0; i < arr.length - 1; i++)
            {
                if (arr[i] > arr[i + 1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    hasSwapped = true;
                }
            }

            if (!hasSwapped)
            {
                done = true;
            }
        }



        System.out.println("Final");
        for (int i : arr) 
        {
            System.out.println(i);
        }
    }

}
