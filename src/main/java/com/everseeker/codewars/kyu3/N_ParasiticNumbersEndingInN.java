package com.everseeker.codewars.kyu3;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by everseeker on 2017/2/22.
 */
public class N_ParasiticNumbersEndingInN {
    public static String calculateSpecial(int lastDigit, int radix) {
        StringBuffer repetend = new StringBuffer();
        int len = calRepetend(lastDigit * radix - 1, radix, repetend);
        BigDecimal bd = new BigDecimal("0." + new BigInteger(repetend.toString(), radix).toString());
        System.out.println("bd = " + bd.toString());
        for (int i = lastDigit; i < radix; i++) {
            BigDecimal tmpBig = bd.multiply(BigDecimal.valueOf(i));
            String tmpStr =  tmpBig.compareTo(BigDecimal.ONE) > 0 ? tmpBig.toString().replace(".", "") : tmpBig.toString().substring(2);
            System.out.println(i + "  " + new BigInteger(tmpStr, 10).toString(radix));
        }
        BigDecimal bdn = bd.multiply(BigDecimal.valueOf(lastDigit));
//        System.out.println("bdn = " + bdn.toString());

        String tmp = bdn.compareTo(BigDecimal.ONE) > 0 ? bdn.toString().replace(".", "") : bdn.toString().substring(2);
        String res = new BigInteger(tmp, 10).toString(radix);
//        System.out.println(res);
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
//            if (radix == 16) {
//                if (res > 9)
//                    repetend.append((char)('a' + res - 10));
//                else
//                    repetend.append(res);
//            } else
                repetend.append(res);
            count++;
            remainder = radix * remainder % n;
            if (remainder == 1)
                return count;
        }
    }

    /**
     * 定理：一个分母为N的循环小数的循环节位数最多不超过N-1位。
     *
     */

    public static void main(String[] args) {
//        StringBuffer sb = new StringBuffer();
//        calRepetend(5, 10, sb);
//        System.out.println(sb);
        calculateSpecial(3, 16);
    }
}
