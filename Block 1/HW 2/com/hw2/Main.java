package com.hw2;
public class Main 
{
    public static void main(String[] args)
    {
        LawFirm theLaw = new LawFirm("The Law");
        LawFirmPhysical theLawPhysical = new LawFirmPhysical(theLaw.getName(), "USA");
        LawFirmRemote theLawRemote = new LawFirmRemote(theLaw.getName(), "PST", "thelaw.com");

        Case privateCase1 = new Case("4/16");
        theLaw.getCases().add(privateCase1);

        Client angryConsumer1 = new Client("Angry", "Consumer");
        theLaw.getClients().add(angryConsumer1);

        Plan basicPlan = new Plan(50.00, 10.00);
        Plan moreHoursPlan = new Plan(80.00, 7.00);
        Plan fewHoursPlan = new Plan(30.00, 15.00);
        
        License basicLicense = new License("Basic");
        License advancedLicense = new License("Advanced");

        Secretary janeDoe = new Secretary("Jane", "Doe");
        janeDoe.addWork("Shred papers.");

        Secretary janeDoe2 = new Secretary("Jane", "Doe");

        Lawyer mattJohnson = new Lawyer("Matthew", "Johnson", basicPlan, basicLicense, janeDoe);
        for (Case c : theLaw.getCases()) 
        {
            mattJohnson.getCases().add(c);
        }
        Lawyer numberLawyer = new Lawyer("1", "2", moreHoursPlan, basicLicense, janeDoe);
        Lawyer snake = new Lawyer("Solid", "Snake", fewHoursPlan, advancedLicense, janeDoe);
        Lawyer snakeCopy = new Lawyer("Solid", "Snake", fewHoursPlan, advancedLicense, janeDoe);
        LawyerRemote remoteLawyer = new LawyerRemote("The", "Remote Lawyer", basicPlan, advancedLicense, janeDoe);



        theLaw.getLawyers().add(mattJohnson);
        theLaw.getLawyers().add(numberLawyer);
        theLaw.getLawyers().add(snake);
        theLaw.getLawyers().add(snakeCopy);
        theLaw.getLawyers().add(remoteLawyer);
        theLaw.getSecretaries().add(janeDoe);

        System.out.println(theLaw.toString());
        mattJohnson.printWork();
        janeDoe.toString();
        janeDoe.printWork();

        if (snake.equals(snakeCopy))
        {
            System.out.println("Two snakes.");
        }

        if (snake.equals(mattJohnson))
        {
            System.out.println("Snake is Matt Johnson");
        }

        else
        {
            System.out.println("Snake is not Matt Johnson.");
        }

        if (janeDoe.equals(janeDoe2))
        {
            System.out.println("There are 2 Jane Doe secretaries");
        }

        theLaw.listPlans(5);
    }    
}
