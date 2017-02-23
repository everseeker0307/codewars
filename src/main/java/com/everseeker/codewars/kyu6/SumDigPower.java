package com.everseeker.codewars.kyu6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by everseeker on 2017/2/16.
 */
public class SumDigPower {
    public static List<Long> sumDigPow(long a, long b) {
        List<Long> list = new ArrayList<Long>();
        long x = a;
        while (x <= b) {
            if (isDigPow(x))
                list.add(x);
            x++;
        }
        return list;
    }

    public static boolean isDigPow(long a) {
        char c[] = String.valueOf(a).toCharArray();
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            sum += Math.pow(Integer.valueOf(String.valueOf(c[i])), i + 1);
        }
        return (a == sum);
    }

    public static void main(String[] args) {
        System.out.print(isDigPow(135));
    }
}
