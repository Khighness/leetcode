package top.parak.Leetcode;

import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-05-29
 * @apiNote 856. 括号的分数
 */
public class T856 {

    /**
     * 遇到(入栈，遇到)循环弹栈直到匹配(
     */
    public int scoreOfParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                int tmp = 0;
                if (stack.peek() == '(') {
                    tmp = 1;
                } else {
                    while (stack.peek() != '(') {
                        tmp += stack.pop() - '0';
                    }
                    tmp *= 2;
                }
                stack.pop();
                stack.push((char) (tmp + '0'));
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) ans += stack.pop() - '0';
        return ans;
    }

}
