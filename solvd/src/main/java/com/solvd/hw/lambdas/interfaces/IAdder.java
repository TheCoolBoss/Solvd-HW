package com.solvd.hw.lambdas.interfaces;

import java.util.ArrayList;

public interface IAdder <T>
{
    void add(ArrayList<T> objectsToAdd, ArrayList<T> listToReceive);
}
