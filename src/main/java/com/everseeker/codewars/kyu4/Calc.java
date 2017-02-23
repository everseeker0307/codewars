package com.everseeker.codewars.kyu4;

import java.util.Stack;

/**
 * Created by everseeker on 2017/2/17.
 */
public class Calc {
    public static double evaluate(String expr) {
        if (expr.equals(""))
            return 0;
        Stack<Double> stack = new Stack<Double>();
        String[] digits = expr.split(" ");
        int len = digits.length;
        for (int i = 0; i < len; i++) {
            if (digits[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (digits[i].equals("-")) {
                double tmp = stack.pop();
                stack.push(stack.pop() - tmp);
            } else if (digits[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (digits[i].equals("/")) {
                double tmp = stack.pop();
                stack.push(stack.pop() / tmp);
            } else {
                stack.push(Double.valueOf(digits[i]));
            }
        }

        return stack.peek();

    }

    public static void main(String[] args) {
        System.out.print(evaluate(""));
    }
}
