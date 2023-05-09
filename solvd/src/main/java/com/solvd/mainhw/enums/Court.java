package com.solvd.mainhw.enums;

public enum Court 
{
    FEDERAL("Federal Court"), 
    STATE("State Court");

    private String name;
    
    Court(String name)
    {
        this.name = name;
    }

    public void adjustName(String toAdd)
    {
        this.name = this.name.concat(" " + toAdd);
    }
}
