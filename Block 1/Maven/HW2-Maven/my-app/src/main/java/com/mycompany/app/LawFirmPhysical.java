package com.mycompany.app;

public class LawFirmPhysical extends LawFirm
{
    private String location;

    public LawFirmPhysical(String name, String location)
    {
        super(name.concat("(Physical)"));
        this.location = location;
    }

    public String getLocation()
    {
        return this.location;
    }

    public void setLocation(String newLoc)
    {
        this.location = newLoc;
    }
}
