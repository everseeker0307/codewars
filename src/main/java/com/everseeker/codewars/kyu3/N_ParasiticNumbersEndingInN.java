package com.everseeker.codewars.kyu3;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by everseeker on 2017/2/22.
 */
public class N_ParasiticNumbersEndingInN {

    public static String calculateSpecial(int lastDigit, int radix) {
        if (lastDigit == 1)
            return "1";
        int maxDivisor = lastDigit * radix - 1;
        int divisor;
        int repetendLength;
        BigDecimal[] bds = new BigDecimal[radix - lastDigit];
        for (int i = lastDigit; i < radix; i++) {
            if (i != 1 && maxDivisor % i == 0) {
                divisor = maxDivisor / i;
                if (divisor % 2 == 0 || divisor % 5 == 0) {
                    continue;
                }
                repetendLength = calRepetend(divisor, radix);
//                System.out.println(i + " " + repetendLength);
                bds[i-lastDigit] = BigDecimal.valueOf(Math.pow(radix, repetendLength) - 1).divide(BigDecimal.valueOf(divisor), repetendLength, BigDecimal.ROUND_DOWN);
            } else {
                repetendLength = calRepetend(maxDivisor, radix);
//                System.out.println(i + " " + repetendLength);
                bds[i-lastDigit] = BigDecimal.valueOf(Math.pow(radix, repetendLength) - 1).multiply(BigDecimal.valueOf(i)).divide(BigDecimal.valueOf(maxDivisor), repetendLength + 2, BigDecimal.ROUND_DOWN);
            }
//            System.out.println(bds[i-lastDigit]);
        }
        BigDecimal min = bds[0];
        for (BigDecimal b : bds) {
            if (b != null && min.compareTo(b) > 0)
                min = b;
        }
        String minStr = min.toString();

        return new BigInteger(minStr.substring(0, minStr.indexOf(".")), 10).toString(radix);
    }

    public static int calRepetend(int n, int radix) {
        int count = 0;
        int remainder = 1;
        while (true) {
            count++;
            remainder = radix * remainder % n;
            if (remainder == 1)
                return count;
        }
    }

    public static String calculateSpecial2(int lastDigit, int radix) {
        StringBuffer repetend = new StringBuffer();
        calRepetend(lastDigit * radix - 1, radix, repetend);
        BigDecimal bd = new BigDecimal("0." + new BigInteger(repetend.toString(), radix).toString());
        BigDecimal bdn = bd.multiply(BigDecimal.valueOf(lastDigit));

        String tmp = bdn.compareTo(BigDecimal.ONE) > 0 ? bdn.toString().replace(".", "") : bdn.toString().substring(2);
        String res = new BigInteger(tmp, 10).toString(radix);
        return res;
    }

    /**
     * 计算1/n的循环节长度以及循环节
     * @param n
     * @param radix :=8, 10 or 16
     * @param repetend :output
     * @return count :返回循环节的长度
     */
    public static int calRepetend(int n, int radix, StringBuffer repetend) {
        int count = 0;
        int remainder = 1;
        while (true) {
            int res = radix * remainder / n;
            repetend.append(res);
            count++;
            remainder = radix * remainder % n;
            if (remainder == 1)
                return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(calculateSpecial(4, 10));
        System.out.println(calculateSpecial(5, 10));
        System.out.println(calculateSpecial(4, 16));
        System.out.println(calculateSpecial(3, 16));
        //calculateSpecial(2, 8) 测试没有通过
        System.out.println(calculateSpecial(2, 8));
    }
}
