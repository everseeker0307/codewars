package com.everseeker.codewars.kyu5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by everseeker on 2017/2/16.
 */
public class Josephus {
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> list = new ArrayList<T>(items);
        List<T> dest = new ArrayList<T>();
        int i = 0;
        while (!list.isEmpty()) {
            i = (i + k - 1) % list.size();
            dest.add(list.remove(i));
        }
        return dest;
    }
}