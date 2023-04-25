package com.hw2;

import java.util.ArrayList;

public class Main 
{
    public static void main(String[] args)
    {
        ArrayList<LawFirm> lawFirms = new ArrayList<LawFirm>();
        LawFirm theLaw = new LawFirm("The Law");
        LawFirmPhysical theLawPhysical = new LawFirmPhysical(theLaw.getName(), "USA");
        LawFirmRemote theLawRemote = new LawFirmRemote(theLaw.getName(), "PST", "thelaw.com");
        lawFirms.add(theLaw);
        lawFirms.add(theLawPhysical);
        lawFirms.add(theLawRemote);

        Case privateCase1 = new Case("Dummy Case", "4/16", "Test Plaintiff", "Test Defendant");
        Case defamation1 = new CaseDefamation("Defamation 1", "4/22", "Plaintiff", "Defendant");
        theLaw.getCases().add(privateCase1);
        theLaw.getCases().add(defamation1);

        defamation1.close();
        defamation1.reOpen();

        Client angryConsumer1 = new Client("Angry", "Consumer");
        theLaw.getClients().add(angryConsumer1);

        Plan basicPlan = new Plan(50.00, 10.00);
        Plan moreHoursPlan = new Plan(80.00, 7.00);
        Plan fewHoursPlan = new Plan(30.00, 15.00);
        
        License basicLicense = new License("Basic");
        License advancedLicense = new License("Advanced");

        Secretary janeDoe = new Secretary("Jane", "Doe", 10, "5/4/32");
        janeDoe.addWork("Shred papers.");

        Secretary janeDoe2 = new Secretary("Jane", "Doe", 10, "5/4/32");

        Lawyer mattJohnson = new Lawyer("Matthew", "Johnson", basicPlan, basicLicense, janeDoe, "4/20/23", 1);
        for (Case c : theLaw.getCases()) 
        {
            mattJohnson.getCases().add(c);
        }

        Lawyer numberLawyer = new Lawyer("1", "2", moreHoursPlan, basicLicense, janeDoe, "4/4", 2);
        Lawyer snake = new Lawyer("Solid", "Snake", fewHoursPlan, advancedLicense, janeDoe, "1/1/11", 3);
        Lawyer snakeCopy = new Lawyer("Solid", "Snake", fewHoursPlan, advancedLicense, janeDoe, "1/1/11", 3);
        LawyerRemote remoteLawyer = new LawyerRemote("The", "Remote Lawyer", basicPlan, advancedLicense, janeDoe, "1/2/34", 5);



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

        printBreak();
        theLaw.listPlans(5);
        printBreak();
        theLaw.getLawyers().remove(snakeCopy);
        snakeCopy.fire();
        printBreak();

        theLaw.closeDown();
        theLawPhysical.closeDown();
        theLawRemote.closeDown();

        clearLawFirms(lawFirms);
    }    

    public static void printBreak()
    {
        System.out.println("");
    }

    public static void clearLawFirms(ArrayList<LawFirm> firms)
    {
        //ConcurrentModificationException happens if removing is done during iteration
        ArrayList<Integer> indicesToRemove = new ArrayList<Integer>();

        for (LawFirm firm : firms) 
        {
            if (firm.getName().contains("closed"))
            {
                System.out.println("Removing law firm " + firm.getName());
                indicesToRemove.add(firms.indexOf(firm));
            }
        }

        for (Integer index : indicesToRemove)
        {
            firms.remove(index);
        }
    }
}
