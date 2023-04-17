public class License 
{
    //Not actually sure if there are different types, just added it for another field
    private String type;
    private boolean isActive;    

    public License(String type)
    {
        this.type = type;
        this.isActive = true;
    }

    public String getType()
    {
        return this.type;
    }

    public boolean getStatus()
    {
        return this.isActive;
    }

    public void setType(String newType)
    {
        this.type = newType;
    }

    public void setStatus(boolean newStatus)
    {
        this.isActive = newStatus;
    }

}
