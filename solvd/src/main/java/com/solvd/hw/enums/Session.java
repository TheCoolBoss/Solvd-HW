package com.solvd.hw.enums;

//While it would make more sense to have this be a class, with clients, I don't think such info should be public 
public enum Session 
{
    IN_PERSON("At office"),
    REMOTE("Online");

    private String location;

    Session(String loc)
    {
        this.location = loc;
    }

    public String getLocation()
    {
        return this.location;
    }
}
