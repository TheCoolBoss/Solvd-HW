package com.solvd.hw.lambdas;

import java.util.*;
import com.solvd.hw.*;
import com.solvd.hw.lambdas.interfaces.IAdder;

public class Adders 
{
    public IAdder<Case> caseAdder = (ArrayList<Case> listToAdd, ArrayList<Case> listToReceive) ->
    {
        listToReceive.addAll(listToAdd);
    };

    public IAdder<Lawyer> lawyerAdder = (ArrayList<Lawyer> lawyerList, ArrayList<Lawyer> lawFirmList) ->
    {
        lawFirmList.addAll(lawyerList);
    };
}
