package com.everseeker.codewars.kyu6;

/**
 * Created by everseeker on 2017/2/16.
 */
public class Consecutivestrings {
    public static String longestConsec(String[] strarr, int k) {
        int len = strarr.length;
        if (k > len || k <= 0)
            return "";
        int key = 0;
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += strarr[i].length();
        int maxSum = sum;
        for (int j = k; j < len; j++) {
            sum = sum + strarr[j].length() - strarr[j - k].length();
            if (sum > maxSum) {
                key = j - k + 1;
                maxSum = sum;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int t = 0; t < k; t++) {
            sb.append(strarr[key]);
            key++;
        }
        return  sb.toString();
    }

    public static void main(String[] args) {
        System.out. println(longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2));
    }
}
