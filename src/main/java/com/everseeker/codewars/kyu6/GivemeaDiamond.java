package com.everseeker.codewars.kyu6;

/**
 * Created by everseeker on 2017/2/16.
 */
public class GivemeaDiamond {
    public static String print(int n) {
        if (n <= 0 || n % 2 == 0)
            return null;

        StringBuffer sb = new StringBuffer();
        int blankNum = n / 2 + 1;
        int starNum = -1;
        for (int i = 0; i <= n/2; i++) {
            blankNum--;
            starNum += 2;
            add(sb, blankNum, starNum);
        }
        for (int j = (n+1)/2; j < n; j++) {
            blankNum++;
            starNum -= 2;
            add(sb, blankNum, starNum);
        }

        return sb.toString();
    }

    public static void add(StringBuffer sb, int blank, int star) {
        while (blank > 0) {
            sb.append(" ");
            blank--;
        }
        while (star > 0) {
            sb.append("*");
            star--;
        }
        sb.append("\n");
    }

    public static void main(String[] args) {
        System.out.print(print(5));
    }
}
