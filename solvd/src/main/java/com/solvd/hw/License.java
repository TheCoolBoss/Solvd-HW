package com.solvd.hw;

import com.solvd.hw.enums.*;
import com.solvd.hw.interfaces.*;

public class License implements Revokable
{
    private LicenseType type;
    private boolean isActive;    

    public License(LicenseType type)
    {
        this.type = type;
        this.isActive = true;
    }

    public LicenseType getType()
    {
        return this.type;
    }

    public boolean getStatus()
    {
        return this.isActive;
    }

    public void setType(LicenseType newType)
    {
        this.type = newType;
    }

    public void setStatus(boolean newStatus)
    {
        this.isActive = newStatus;
    }

    public void revoke()
    {
        this.type = LicenseType.REVOKED;
        this.isActive = false;
    }

    public void reInstate()
    {
        this.type = LicenseType.BASIC;
        this.isActive = true;
    }
}
