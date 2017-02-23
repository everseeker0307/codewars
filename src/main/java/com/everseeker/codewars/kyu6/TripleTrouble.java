package com.everseeker.codewars.kyu6;

/**
 * Created by everseeker on 2017/2/16.
 */
public class TripleTrouble {
    public static int TripleDouble(long num1, long num2)
    {
        String str1 = String.valueOf(num1);
        StringBuffer sb1 = new StringBuffer();
        for (int l1 = str1.length() - 1; l1 > 1; l1--) {
            if (str1.charAt(l1) == str1.charAt(l1 - 1) && str1.charAt(l1) == str1.charAt(l1 - 2))
                sb1.append(str1.charAt(l1));
        }
        String str2 = String.valueOf(num2);
        StringBuffer sb2 = new StringBuffer();
        for (int l2 = str2.length() - 1; l2 > 0; ) {
            if (str2.charAt(l2) == str2.charAt(--l2))
                sb2.append(str2.charAt(l2));
        }
        for (int lsb2 = sb2.length() - 1; lsb2 >= 0; lsb2--)
            if (sb1.toString().contains(String.valueOf(sb2.charAt(lsb2))))
                return 1;

        return 0;
    }
}
