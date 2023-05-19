package com.solvd.hw.lambdas;

import java.util.*;
import com.solvd.hw.*;
import com.solvd.hw.lambdas.interfaces.IAdder;

public class Adders 
{
    public static final IAdder<Case> CASE_ADDER = (ArrayList<Case> listToAdd, ArrayList<Case> listToReceive) ->
    {
        listToReceive.addAll(listToAdd);
    };

    public static final IAdder<Lawyer> LAWYER_ADDER = (ArrayList<Lawyer> lawyerList, ArrayList<Lawyer> lawFirmList) ->
    {
        lawFirmList.addAll(lawyerList);
    };
}
