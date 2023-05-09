package com.solvd.hw.enums;

public enum Session 
{
    IN_PERSON("At office"),
    REMOTE("Online");

    private String location;

    Session(String loc)
    {
        this.location = loc;
    }
}
