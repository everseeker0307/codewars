package com.everseeker.codewars.kyu6;

/**
 * Created by everseeker on 2017/2/16.
 */
public class Scramblies {
    public static boolean scramble(String str1, String str2) {
        if (str2.length() > str1.length())
            return false;

        StringBuffer sb = new StringBuffer(str1);
        for (int i = str2.length() - 1; i >=0; i--) {
            int j = sb.lastIndexOf(String.valueOf(str2.charAt(i)));
            if (j < 0)
                return false;
            sb.deleteCharAt(j);
        }

        return true;
    }
}
