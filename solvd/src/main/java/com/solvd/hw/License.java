package com.solvd.hw;

import com.solvd.hw.enums.*;
import com.solvd.hw.interfaces.*;

public class License implements Revokable
{
    private LicenseType type;
    private boolean isActive;    

    public License(String type)
    {
        if (type.equalsIgnoreCase("basic"))
        {
            this.type = LicenseType.BASIC;
        }

        else if (type.equalsIgnoreCase("advanced"))
        {
            this.type = LicenseType.ADVANCED;
        }

        else if (type.equalsIgnoreCase("revoked"))
        {
            this.type = LicenseType.REVOKED;
        }

        else
        {
            this.type = LicenseType.OTHER;
        }

        this.isActive = true;
    }

    public String getType()
    {
        return this.type.toString();
    }

    public boolean getStatus()
    {
        return this.isActive;
    }

    public void setType(String newType)
    {
        this.type = LicenseType.valueOf(newType);
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
