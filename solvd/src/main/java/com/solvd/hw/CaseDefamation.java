package com.solvd.hw;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CaseDefamation extends Case
{
    private final static Logger LOGGER = LogManager.getLogger(CaseDefamation.class);

    public CaseDefamation(String title, String date, String plaintiff, String defendant, int duration)
    {
        super(title, date, plaintiff, defendant, duration);
    }

    public final void printDetails()
    {
        LOGGER.info("Plaintiff " + this.getPlaintiff() + " is suing " + this.getDefendant() + " for defamation.");
    }
}
