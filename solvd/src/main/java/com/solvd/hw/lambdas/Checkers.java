package com.solvd.hw.lambdas;

import java.util.*;
import com.solvd.hw.enums.Session;
import com.solvd.hw.lambdas.interfaces.ICheckers;

public class Checkers 
{
    public static final ICheckers<Session> IN_PERSON_CHECKER = (ArrayList<Session> list) ->
    {
        return list.stream()
        .allMatch((Session session) -> session.getLocation().equals("In person"));
    };
}
