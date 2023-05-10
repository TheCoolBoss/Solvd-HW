package com.solvd.hw.enums;

public enum SecretaryWork 
{
    //Wasn't sure on what to constant values to use so came up with these

    SHRED("Shredding paperwork", 2),
    SORT_FILES("Sorting case files", 4), 
    CHECK_SCHEDULE("Checking lawyer's schedule", 1);

    private String type;
    private int duration;

    SecretaryWork(String type, int duration)
    {
        this.type = type;
        this.duration = duration;
    }

    public String getType()
    {
        return this.type;
    }

    public int getDuration()
    {
        return this.duration;
    }
}
