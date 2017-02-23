package com.everseeker.codewars.kyu3;

import java.math.BigInteger;

/**
 * Created by everseeker on 2017/2/21.
 */
public class Fibonacci {

    public static BigInteger fib(BigInteger n) {
        if (n.longValue() == 0 || n.longValue() == 1)
            return n;
        /**
         * f(n) = f(x) * f(n-x+1) + f(x-1) * f(n-x)
         * down = {fib0, fib1, fib3, fib7, fib15, fib31 ...}
         * up   = {fib1, fib2, fib4, fib8, fib16, fib32 ...}
         */
        BigInteger abs = BigInteger.valueOf(Math.abs(n.longValue()));
        char[] c = Long.toBinaryString(abs.longValue()).toCharArray();
        int len = c.length;
        BigInteger[] down = new BigInteger[len];
        BigInteger[] up = new BigInteger[len];
        down[0] = BigInteger.valueOf(0);
        up[0] = BigInteger.valueOf(1);
        for (int i = 1; i < len; i++) {
            /**
             * n为偶数时, f(n) = f(n/2) * (f(n/2) + 2f(n/2-1))
             * n为奇数时, f(n) = f((n+1)/2) * f((n+1)/2) + f((n-1)/2) * f((n-1)/2)
             */
            down[i] = (up[i-1].multiply(up[i-1])).add(down[i-1].multiply(down[i-1]));
            up[i] = up[i-1].multiply(up[i-1].add(down[i-1].multiply(BigInteger.valueOf(2))));
        }

        if (n.longValue() < 0 && n.longValue() % 2 == 0)
            return BigInteger.valueOf(0).subtract(calFib(abs, up, down));

        return calFib(abs, up, down);
    }

    public static BigInteger calFib(BigInteger n, BigInteger[] up, BigInteger[] down) {
        int len = Long.toBinaryString(n.longValue()).toCharArray().length;
        long v = n.longValue() - (long)Math.pow(2, len-1);
        if (v == 0)
            return up[len-1];
        return (up[len-1].multiply(calFib(BigInteger.valueOf(v+1), up, down))).add(down[len-1].multiply(calFib(BigInteger.valueOf(v), up, down)));
    }

    public static void main(String[] args) {
        System.out.println(fib(BigInteger.valueOf(-96)));
    }
}
