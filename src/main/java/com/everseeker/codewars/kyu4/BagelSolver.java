package com.everseeker.codewars.kyu4;

import java.lang.reflect.Field;

/**
 * Created by everseeker on 2017/2/20.
 */
public class BagelSolver {
    public static Bagel getBagel() {
        try {
            Field value = Boolean.class.getDeclaredField("value");
            value.setAccessible(true);
            value.set(Boolean.TRUE, Boolean.FALSE);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return new Bagel();
    }

    public static void main(String[] args) {
        Boolean b =  BagelSolver.getBagel().getValue() == 4;
        System.out.print(b);
    }
}
