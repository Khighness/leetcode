package top.parak.Leetcode;

import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-08-08
 */

public class T150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (isNumber(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                stack.push(calculate(s, stack));
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String s) {
        return !((s.equals("+")) || (s.equals("-")) || (s.equals("*")) || (s.equals("/")));
    }

    private int calculate(String s, Stack<Integer> stack) {
        int ans = 0;
        int num2 = stack.pop(), num1 = stack.pop();
        switch (s) {
            case "+": ans = num1 + num2; break;
            case "-": ans = num1 - num2; break;
            case "*": ans = num1 * num2; break;
            case "/": ans = num1 / num2; break;
            default: break;
        }
        return ans;
    }
}
