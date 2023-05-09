package com.solvd.hw.enums;

public enum LicenseType 
{
    BASIC("Basic"),
    ADVANCED("Advanced"),
    REVOKED("Revoked"),
    OTHER("Other");

    private String type;
    LicenseType(String type)
    {
        this.type = type;
    }
}
