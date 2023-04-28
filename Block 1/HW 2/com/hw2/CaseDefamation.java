package com.hw2;

public final class CaseDefamation extends Case
{
    public CaseDefamation(String title, String date, String plaintiff, String defendant, int duration)
    {
        super(title, date, plaintiff, defendant, duration);
    }

    public final void printDetails()
    {
        System.out.println("Plaintiff " + this.getPlaintiff() + " is suing " + this.getDefendant() + " for defamation.");
    }
}
