package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-29
 * @apiNote 面试题 16.26. 计算器
 */

import java.util.Stack;
import java.util.UUID;

/**
 * Problem:
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 */
public class Face1626 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        char pre = '+';
        int cur = 0, ans = 0, len = arr.length;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(arr[i])) {
                cur = cur * 10 + arr[i] - '0';
            }
            if (i == len - 1 || arr[i] != ' ' && !Character.isDigit(arr[i])) {
                switch (pre) {
                    case '+': stack.push(cur);break;
                    case '-': stack.push(-cur);break;
                    case '*': stack.push(stack.pop() * cur);break;
                    case '/': stack.push(stack.pop() / cur);break;
                }
                pre = arr[i];
                cur = 0;
            }
        }
        while (!stack.isEmpty()) ans += stack.pop();
        return ans;
    }
}
