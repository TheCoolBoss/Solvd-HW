package com.solvd.hw.lambdas;

import java.util.*;
import com.solvd.hw.enums.Session;
import com.solvd.hw.lambdas.interfaces.ICheckers;

public class Checkers 
{
    public ICheckers<Session> inPersonSessionChecker = (ArrayList<Session> list) ->
    {
        return list.stream()
        .allMatch((Session session) -> session.getLocation().equals("In person"));
    };
}
