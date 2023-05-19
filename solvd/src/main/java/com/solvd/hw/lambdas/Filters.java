package com.solvd.hw.lambdas;

import java.util.*;
import java.util.stream.*;
import com.solvd.hw.*;
import com.solvd.hw.enums.LicenseType;
import com.solvd.hw.lambdas.interfaces.IFilter;
import java.util.function.*;

public class Filters
{
    //While it would be better to have a title parameter, the filter method signature is just a list to filter
    public static final IFilter<Case> PRIVATE_CASES = (ArrayList<Case> caseList) ->
    {
        return (ArrayList<Case>) caseList.stream()
        .filter((Case c) -> c.getTitle().equals("Private Case"))
        .collect(Collectors.toList());
        
    };

    public static final IFilter<Case> PUBLIC_CASES = (ArrayList<Case> caseList) ->
    {
        return (ArrayList<Case>) caseList.stream()
        .filter((Case c) -> !c.getTitle().equals("Private Case"))
        .collect(Collectors.toList());
    };
    
    public static final Predicate<Lawyer> BASIC_LAWYERS = (Lawyer current) -> current.getLicense().getType().equals(LicenseType.BASIC);


    public static final IFilter<Lawyer> LAWYERS_WITHOUT_CASES = (ArrayList<Lawyer> lawyerList) ->
    {
        return (ArrayList<Lawyer>) lawyerList.stream()
        .filter((Lawyer lawyer) -> lawyer.getCases().size() == 0)
        .collect(Collectors.toList());
    };

    public static final IFilter<Lawyer> REMOTE_LAWYERS = (ArrayList<Lawyer> lawyers) ->
    {
        return (ArrayList<Lawyer>) lawyers.stream()
        .filter((Lawyer lawyer) -> lawyer instanceof LawyerRemote)
        .collect(Collectors.toList());
    };
}

