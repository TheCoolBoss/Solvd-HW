package com.solvd.hw;

import java.util.function.BinaryOperator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hw.exceptions.ClosedCaseException;
import com.solvd.hw.interfaces.Closable;

public class Case implements Closable
{
    private static final Logger LOGGER = LogManager.getLogger(Case.class);
    private static final BinaryOperator<String> CONCATER = (String s1, String s2) -> s1.concat(s2);
    private String title;
    private String date;
    private String plaintiff;
    private String defendant;
    private int duration;
    private boolean isOpen;

    public Case(String title, String date, String plaintiff, String defendant, int duration)
    {
        this.title = title;
        this.date = date;
        this.plaintiff = plaintiff;
        this.defendant = defendant;
        this.isOpen = true;
        this.duration = duration;
    }

    public Case(String date, String plaintiff, String defendant, int duration)
    {
        this("Private Case", date, plaintiff, defendant, duration);
    }

    //Get/setters
    public String getTitle()
    {
        return this.title;
    }

    public String getDate()
    {
        return this.date;
    }

    public String getPlaintiff()
    {
        return this.plaintiff;
    }

    public String getDefendant()
    {
        return this.defendant;
    }

    public boolean getStatus()
    {
        return this.isOpen;
    }

    public int getDuration()
    {
        return this.duration;
    }

    //I feel like case info shouldn't be changeable if closed, since it's not relevant anymore
    //Exception for the actual status
    public void setTitle(String newTitle) throws ClosedCaseException
    {
        if (!isOpen)
        {
            throw new ClosedCaseException(title);
        }

        this.title = newTitle;
    }

    public void setDate(String newDate) throws ClosedCaseException
    {
        if (!isOpen)
        {
            throw new ClosedCaseException(title);
        }
        
        this.date = newDate;
    }

    public void setDuration(int newDuration) throws ClosedCaseException
    {
        if (!isOpen)
        {
            throw new ClosedCaseException(title);
        }
        
        this.duration = newDuration;
    }

    public void setStatus(boolean newStatus)
    {
        this.isOpen = newStatus;
    }

    //Misc
    public String toString()
    {
        String toRet = "Case " + title + " of date " + date + " is ";
        String status = "";
        if (isOpen)
        {
            status = "open.";
        }

        else
        {
            status = "closed.";
        }

        return CONCATER.apply(toRet, status);
    }

    public void close()
    {
        LOGGER.info("Closing case " + title);
        setStatus(false);

        try
        {
            setTitle(CONCATER.apply(title, " (Closed)"));
        }

        catch (ClosedCaseException cce)
        {
           LOGGER.error(cce.getMessage());
        }
    }

    public void reOpen()
    {
        LOGGER.info("Reopening case " + title);
        setStatus(true);
        if (!title.contains("Closed"))
        {
            LOGGER.error("Case is already open.");
        }

        else
        {
            try
            {
                setTitle(title.substring(0, title.indexOf("(Closed)")));
            }
    
            catch (ClosedCaseException cce)
            {
                LOGGER.error(cce.getMessage());
            }
        }
    }
}
