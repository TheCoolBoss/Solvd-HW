package com.solvd.hw.lambdas;

import java.util.*;

public interface NameFilter <T>
{
    ArrayList<T> filter(ArrayList<T> list, String filter);
}
