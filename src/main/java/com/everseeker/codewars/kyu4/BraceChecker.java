package com.everseeker.codewars.kyu4;

import java.util.Stack;

/**
 * Created by everseeker on 2017/2/21.
 */
public class BraceChecker {

    public static boolean isValid(String braces) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : braces.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')': {
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                }
                case ']': {
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
                }
                case '}': {
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
                }
                default:
                    return false;
            }
        }

        if (stack.isEmpty())
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.print(isValid("[(])"));
    }
}
