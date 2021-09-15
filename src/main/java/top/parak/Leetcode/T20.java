package top.parak.Leetcode;

import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 20. 有效的括号
 */
public class T20 {

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
