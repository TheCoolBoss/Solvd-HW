package com.mycompany.app.Enums;

import java.util.ArrayList;

import org.apache.logging.log4j.core.Logger;

import com.mycompany.app.Case;

public enum Court 
{
    FEDERAL("Federal Court"), 
    STATE("State Court");

    private String name;
    private ArrayList<Case> cases;
    
    Court(String name)
    {
        this.name = name;
        this.cases = new ArrayList<Case>();
    }

    public void adjustName(String toAdd)
    {
        this.name = this.name.concat(" " + toAdd);
    }

    public void addCase(Case newCase)
    {
        this.cases.add(newCase);
    }

    public void resolveCase(Case toResolve, boolean didPlaintiffWin, Logger logger)
    {
        toResolve.close(logger);
        if (didPlaintiffWin)
        {
            logger.info("Plaintiff " + toResolve.getPlaintiff() + " wins!");
        }

        else
        {
            logger.info("Defendant " + toResolve.getDefendant() + " wins!");
        }
    }
}
