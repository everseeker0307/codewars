package com.everseeker.codewars.kyu4;

import java.math.BigInteger;

/**
 * Created by everseeker on 2017/2/20.
 */
public class LargeFactorial {
    public static String Factorial(int n) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = n; i > 0; i--) {
            res = res.multiply(BigInteger.valueOf(i));
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(Factorial(0));
        System.out.println(Long.MAX_VALUE);
    }
}
