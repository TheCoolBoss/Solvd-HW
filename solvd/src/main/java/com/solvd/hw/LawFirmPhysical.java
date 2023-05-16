package com.solvd.hw;

import com.solvd.hw.enums.Court;

public class LawFirmPhysical extends LawFirm
{
    private String location;

    public LawFirmPhysical(String name, String location, Court jurisdiction)
    {
        super(name.concat("(Physical)"), jurisdiction);
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
