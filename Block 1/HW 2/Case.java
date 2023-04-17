public class Case 
{
    private String title;
    private String date;
    private boolean isOpen;

    public Case(String title, String date)
    {
        this.title = title;
        this.date = date;
        this.isOpen = true;
    }

    public Case(String date)
    {
        this.title = "Private Case";
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
}
