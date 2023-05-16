package com.solvd.hw.lambdas;

import java.util.*;
import com.solvd.hw.*;
import com.solvd.hw.enums.SecretaryWork;
import com.solvd.hw.lambdas.interfaces.ISorter;

public class Sorters
{
    public ISorter<Case> caseNameSorter = (ArrayList<Case> list) ->
    {
        list.sort(new java.util.Comparator<Case>() 
        {
            public int compare(Case c1, Case c2)
            {
                return c1.getTitle().compareTo(c2.getTitle());
            }
        });
    };        

    public ISorter<SecretaryWork> secretaryWorkSorter = (ArrayList<SecretaryWork> list) ->
    {
        list.sort(new java.util.Comparator<SecretaryWork>() 
        {
            public int compare(SecretaryWork work1, SecretaryWork work2)
            {
                return work1.compareTo(work2);
            }
        });
    };
}


