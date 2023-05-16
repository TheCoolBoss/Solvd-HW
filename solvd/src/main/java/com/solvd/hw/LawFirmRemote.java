package com.solvd.hw;

import com.solvd.hw.enums.Court;
import com.solvd.hw.enums.Timezone;

public class LawFirmRemote extends LawFirm
{
    private Timezone timeZone;
    private String url;

    public LawFirmRemote(String name, Timezone timeZone, String url, Court jurisdiction)
    {
        super(name.concat("(Remote)"), jurisdiction);
        this.timeZone = timeZone;
        this.url = url;
    }


    public String getTimeZone()
    {
        return this.timeZone.name();
    }

    public String getUrl()
    {
        return this.url;
    }

    public void setTimeZone(Timezone newZone)
    {
        this.timeZone = newZone;
    }

    public void setUrl(String newUrl)
    {
        this.url = newUrl;
    }
}
