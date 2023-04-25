package com.hw2;
public class Case implements Closable
{
    private String title;
    private String date;
    private String plaintiff;
    private String defendant;
    private boolean isOpen;

    public Case(String title, String date, String plaintiff, String defendant)
    {
        this.title = title;
        this.date = date;
        this.plaintiff = plaintiff;
        this.defendant = defendant;
        this.isOpen = true;
    }

    public Case(String date, String plaintiff, String defendant)
    {
        this.title = "Private Case";
        this.plaintiff = plaintiff;
        this.defendant = defendant;
        this.date = date;
        this.isOpen = true;
    }


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

    public void setTitle(String newTitle)
    {
        this.title = newTitle;
    }

    public void setDate(String newDate)
    {
        this.date = newDate;
    }

    public void setStatus(boolean newStatus)
    {
        this.isOpen = newStatus;
    }

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
        setTitle(title.concat("(Closed)"));
    }

    //This assumes that cases don't have a ( in their actual name
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
            setTitle(title.substring(0, title.indexOf("(Closed)")));
        }
    }
}
