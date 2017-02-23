package com.everseeker.codewars.kyu6;

/**
 * Created by everseeker on 2017/2/16.
 */
public class DigitalRoot {
    public static int digital_root(int n) {
        return n / 10 == 0 ? n : digital_root(n % 10 + n / 10);
    }
}
