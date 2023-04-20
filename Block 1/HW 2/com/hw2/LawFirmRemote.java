package com.hw2;
public class LawFirmRemote extends LawFirm
{
    private String timeZone;
    private String url;

    public LawFirmRemote(String name, String timeZone, String url)
    {
        super(name);
        this.timeZone = timeZone;
        this.url = url;
    }


    public String getTimeZone()
    {
        return this.timeZone;
    }

    public String getUrl()
    {
        return this.url;
    }

    public void setTimeZone(String zone)
    {
        this.timeZone = zone;
    }

    public void setUrl(String newUrl)
    {
        this.url = newUrl;
    }
}
