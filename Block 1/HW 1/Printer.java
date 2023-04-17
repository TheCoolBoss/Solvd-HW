public class Printer 
{
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            System.out.println("Missing info. :(");
        }
        else
        {
            for (int i = 0; i < args.length; i++) 
            {
                System.out.println("Info " + i + ": " + args[i]);
            }
            
        }
    }
}
