public class LawFirmRemote extends LawFirm
{
    private String timeZone;

    public LawFirmRemote(String name, String timeZone)
    {
        super(name);
        this.timeZone = timeZone;
    }


    public String getTimeZone()
    {
        return this.timeZone;
    }

    public void setTimeZone(String zone)
    {
        this.timeZone = zone;
    }
}
