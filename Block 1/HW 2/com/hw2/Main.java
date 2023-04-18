package com.hw2;
public class Main 
{
    public static void main(String[] args)
    {
        LawFirm theLaw = new LawFirm("The Law");
        LawFirmPhysical theLawPhysical = new LawFirmPhysical(theLaw.name, "USA");
        LawFirmRemote theLawRemote = new LawFirmRemote(theLaw.name, "PST");

        Case privateCase1 = new Case("4/16");
        theLaw.cases.add(privateCase1);

        Client angryConsumer1 = new Client("Angry", "Consumer");
        theLaw.clients.add(angryConsumer1);

        Plan basicPlan = new Plan(50.00, 10.00);
        Plan moreHoursPlan = new Plan(80.00, 7.00);
        Plan fewHoursPlan = new Plan(30.00, 15.00);
        
        License basicLicense = new License("Basic");
        License advancedLicense = new License("Advanced");

        Lawyer mattJohnson = new Lawyer("Matthew", "Johnson,", basicPlan, basicLicense);
        Lawyer numberLawyer = new Lawyer("1", "2", moreHoursPlan, basicLicense);
        Lawyer anonLawyer = new Lawyer(fewHoursPlan, advancedLicense);
        LawyerRemote remoteLawyer = new LawyerRemote("The", "Remote Lawyer", basicPlan, advancedLicense);

        Secretary janeDoe = new Secretary("Jane", "Doe", mattJohnson);

        theLaw.lawyers.add(mattJohnson);
        theLaw.lawyers.add(numberLawyer);
        theLaw.lawyers.add(anonLawyer);
        theLaw.lawyers.add(remoteLawyer);
        theLaw.secretaries.add(janeDoe);
        theLaw.cases.add(privateCase1);
        theLaw.clients.add(angryConsumer1);
    }    
}
