package com.everseeker.codewars.kyu6;

/**
 * Created by everseeker on 2017/2/16.
 */
public class WriteNumberinExpandedForm {
    public static String expandedForm(int num) {
        StringBuffer sb = new StringBuffer();
        int reminder;
        int digit = 0;
        while (num > 0) {
            reminder = num % 10;
            num = num / 10;
            if (reminder > 0)
                sb = sb.insert(0, reminder * (int)Math.pow(10, digit) + " + ");
            digit++;
        }
        return sb.substring(0, sb.length() - 3);
    }

    public static void main(String[] args) {
//        System.out.print(WriteNumberinExpandedForm.expandedForm(1200));
        WriteNumberinExpandedForm.race(80, 100, 40);
    }

    public static int[] race(int v1, int v2, int g) {
        if (v1 >= v2) return null;
        int[] r = new int[3];
        double th = (double)g / (v2 - v1);
        r[0] = (int)Math.floor(th);
        double tmn = (th - r[0]) * 60;
        r[1] = (int)Math.floor(tmn);
        r[2] = (int)((tmn - r[1]) * 60);
        System.out.print(r[0] + " " + r[1] + " " + r[2]);
        return r;
    }
}
