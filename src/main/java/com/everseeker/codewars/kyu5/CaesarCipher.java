package com.everseeker.codewars.kyu5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by everseeker on 2017/2/16.
 */
public class CaesarCipher {
    public static List<String> movingShift(String s, int shift) {
        char c[] = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (c[i] >= 'A' && c[i] <= 'Z') {
                int lc = (int)c[i] + shift % 26;
                c[i] = (lc > 90) ? (char)(lc - 26) : (char)lc;
            } else if (c[i] >= 'a' && c[i] <= 'z') {
                int lc = (int)c[i] + shift % 26;
                c[i] = (lc > 122) ? (char)(lc - 26) : (char)lc;
            }
            shift = ++shift % 26;
        }

        int step = (len % 5 == 0) ? len / 5 : len / 5 + 1;
        List<String> list = new ArrayList<String>();
        for (int k = 0; k < 4; k++) {
            list.add(String.valueOf(c, k * step, step));
        }
        list.add(String.valueOf(c, 4 * step, len - 4 * step));
        return list;
    }

    public static String demovingShift(List<String> s, int shift) {
        StringBuffer sb = new StringBuffer();
        for (String each : s)
            sb.append(each);
        char c[] = sb.toString().toCharArray();
        int len = c.length;
        for (int i = 0; i < len; i++) {
            if (c[i] >= 'A' && c[i] <= 'Z') {
                int lc = (int)c[i] - shift % 26;
                c[i] = (lc < 65) ? (char)(lc + 26) : (char)lc;
            } else if (c[i] >= 'a' && c[i] <= 'z') {
                int lc = (int)c[i] - shift % 26;
                c[i] = (lc < 97) ? (char)(lc + 26) : (char)lc;
            }
            shift = ++shift % 26;
        }

        return String.valueOf(c);
    }

    public static void main(String[] args) {
        String u = "I should have known that you would have a perfect answer for me!!!";
        movingShift(u, 1);
    }
}
