package com.hw2;

import org.apache.logging.log4j.Logger;

public final class CaseDefamation extends Case
{
    public CaseDefamation(String title, String date, String plaintiff, String defendant, int duration)
    {
        super(title, date, plaintiff, defendant, duration);
    }

    public final void printDetails(Logger logger)
    {
        logger.info("Plaintiff " + this.getPlaintiff() + " is suing " + this.getDefendant() + " for defamation.");
    }
}
