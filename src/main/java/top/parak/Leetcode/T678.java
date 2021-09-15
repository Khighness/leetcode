package top.parak.Leetcode;

import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-09-12
 * @apiNote 678. 有效的括号字符串
 */
public class T678 {

    public boolean checkValidString(String s) {
        // 左括号
        Stack<Integer> s1 = new Stack<>();
        // 星号
        Stack<Integer> s2 = new Stack<>();
        char[] arr = s.toCharArray();
        // 星号作为左括号
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                s1.push(i);
            } else if (arr[i] == '*') {
                s2.push(i);
            } else {
                if (!s1.isEmpty()) {
                    s1.pop();
                } else if (s2.isEmpty()) {
                    s2.pop();
                } else {
                    return false;
                }
            }
        }
        // 星号作为右括号
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.peek() > s2.peek()) {
                return false;
            }
            s1.pop();
            s2.pop();
        }
        return s1.isEmpty();
    }

}
