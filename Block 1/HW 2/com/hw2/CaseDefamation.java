package com.hw2;

public final class CaseDefamation extends Case
{
    public CaseDefamation(String title, String date, String plaintiff, String defendant)
    {
        super(title, date, plaintiff, defendant);
    }

    public final void printDetails()
    {
        System.out.println("Plaintiff " + this.getPlaintiff() + " is suing " + this.getDefendant() + " for defamation.");
    }
}
