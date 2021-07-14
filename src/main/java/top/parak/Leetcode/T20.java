package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 20. 有效的括号
 */

import java.util.Stack;

/**
 * Problem:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class T20 {
    /**
     * 栈
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (c == ')' && stack.peek() != '('
                ||  c == '}' && stack.peek() != '{'
                ||  c == ']' && stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
