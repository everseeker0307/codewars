package com.everseeker.codewars.kyu6;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by everseeker on 2017/2/16.
 */
public class AlternatingSplit {
    public static String encrypt(final String text, final int n) {
        if (text == null || text == "" || n <=0)
            return text;

        String s = text;
        for(int i = n; i > 0; i--) {
            s = encrypt2(s);
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.print(encrypt("This is a test!", 2));
//        System.out.print(decrypt(" Tah itse sits!", 3));
    }

    public static String encrypt(final String text) {
        LinkedList<Character> linkText = new LinkedList<Character>();
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for(char c : text.toCharArray())
            linkText.add(c);
        Iterator<Character> iter = linkText.iterator();
        while (iter.hasNext()) {
            sb1.append(iter.next());
            if (iter.hasNext())
                sb2.append(iter.next());
        }

        return sb2.append(sb1).toString();
    }

    public static String encrypt2(final String text) {
        int length = text.length();
        char[] source = text.toCharArray();
        char[] dest = new char[length];
        for (int i = 0, j = length / 2; i < length; i++) {
            if (i % 2 == 0) {
                dest[j] = source[i];
                j++;
            } else
                dest[(i + 1) / 2] = source[i];
        }

        return String.valueOf(dest);
    }

    public static String decrypt(final String encryptedText, final int n) {
        if (encryptedText == null || encryptedText == "" || n <=0)
            return encryptedText;

        String s = encryptedText;
        for(int i = n; i > 0; i--) {
            s = decrypt(s);
        }

        return s;
    }

    public static String decrypt(final String encryptedText) {
        int length = encryptedText.length();
        char[] source = encryptedText.toCharArray();
        char[] dest = new char[length];
        for (int i = 0, j = 1; i < length; i++, j += 2) {
            if (j >= length)
                j = 0;
            dest[j] = source[i];
        }

        return String.valueOf(dest);
    }
}
