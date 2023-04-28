package com.hw2;
public class Case implements Closable
{
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
            status = "open";
        }

        else
        {
            status = "closed";
        }

        return toRet.concat(status);
    }

    public void close()
    {
        System.out.println("Closing case " + title);
        setStatus(false);

        try
        {
            setTitle(title.concat("(Closed)"));
        }

        catch (ClosedCaseException cce)
        {
            System.out.println(cce.getMessage());
        }
    }

    public void reOpen()
    {
        System.out.println("Reopening case " + title);
        setStatus(true);
        if (!title.contains("Closed"))
        {
            System.out.println("Case is already open.");
        }

        else
        {
            try
            {
                setTitle(title.substring(0, title.indexOf("(Closed)")));
            }
    
            catch (ClosedCaseException cce)
            {
                System.out.println(cce.getMessage());
            }
        }
    }
}
