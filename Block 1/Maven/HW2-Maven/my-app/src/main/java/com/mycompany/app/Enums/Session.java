package com.mycompany.app.Enums;

import org.apache.logging.log4j.core.Logger;
import com.mycompany.app.Client;
import com.mycompany.app.Lawyer;
import com.mycompany.app.Case;

//Meant to mimic discussion between lawyer and client
public enum Session 
{
    IN_PERSON(null, null),
    REMOTE(null, null);

    private Lawyer consultant;
    private Client consultee;

    Session(Lawyer lawyer, Client client)
    {
        this.consultant = lawyer;
        this.consultee = client;
    }

    public void initParties(Lawyer newConsultant, Client newClient)
    {
        this.consultant = newConsultant;
        this.consultee = newClient;
    }

    public void listClientCases(Logger logger)
    {
        logger.info("Client " + this.consultee.getFirstName() + " " + this.consultee.getLastName() + " says:\n");
        logger.info("I have the following cases:\n");
        for (Case c : this.consultee.getCases()) 
        {
            logger.info(c.getTitle() + " with a duration of " + c.getDuration() + ".\n");
        }
        logger.info("How much will it cost?");
    }

    public void listLawyerFees(Logger logger)
    {
        logger.info("Lawyer " + this.consultant.getFirstName() + " " + this.consultant.getLastName() + " says:\n");
        logger.info("My plan information:\n" + this.consultant.getPlan().toString());
        logger.info("With that information, here are your costs.\n");

        for (Case c : this.consultant.getCases())
        {
            int duration = c.getDuration();
            double total = this.consultant.getPlan().getBaseCost() + (duration * this.consultant.getPlan().getHourRate());
            logger.info("Case " + c.getTitle() + ":");
            logger.info("Total: " + total);
            logger.info("----------------------\n");
        }
    }
}
