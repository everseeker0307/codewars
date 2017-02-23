package com.everseeker.codewars.kyu4;

import java.util.regex.Pattern;

/**
 * Created by everseeker on 2017/2/17.
 */
public class BinaryRegexp {
    /** 利用FSM状态机的原理可以解决此问题 */
    public static Pattern multipleOf3() {
        /**
         * 3种状态A：被3整除； B：余数为1； C：余数为2
         * 初始状态为A，最终状态也为A。满足条件的为以下3种过程的组合：
         * 1. [A]                               对应0
         * 2. [A] -> B -> [A]                   对应11
         * 3. [A] -> B -> [[C] -> B] -> [A]     对应(1(11)*(0(00)*1*0(00)*)+1(11)*)
         * 其中[]表示循环。
         */

        return Pattern.compile("(0|11|(1(11)*(0(00)*1*0(00)*)+1(11)*))*");
    }

    public static boolean divOf3(String str) {
        if (str.equals(""))
            return true;
        char[] c = str.toCharArray();
        int state = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '0') {
                switch (state) {
                    case 0:
                        break;
                    case 1:
                        state = 2;
                        break;
                    case 2:
                        state = 1;
                        break;
                }
            } else if (c[i] == '1') {
                switch (state) {
                    case 0:
                        state = 1;
                        break;
                    case 1:
                        state = 0;
                        break;
                    case 2:
                        break;
                }
            } else {
                return false;
            }
        }

        return (state == 0);
    }

    public static void main(String[] args) {
//        System.out.print(divOf3("110"));
        System.out.print(multipleOf3().matcher("0101011a").matches());
    }
}
