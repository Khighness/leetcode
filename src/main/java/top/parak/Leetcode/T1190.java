package top.parak.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author KHighness
 * @since 2021-05-26
 * @apiNote 1190. 反转每对括号间的子串
 */
public class T1190 {

    /**
     * 双向队列
     * 从前往后遍历字符串，将不是『(』的字符串放入队列尾部
     * 遇到『)』时，从队列尾部取出字符串，直到遇到『(』为止，并对取出字符串进行翻转
     * 翻转完成将字符串重新放入队列，循环上述过程
     * 最后从头部开始取字符，得到结果
     */
    public String reverseParentheses(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c == ')') {
                StringBuilder sb = new StringBuilder();
                while (!deque.isEmpty()) {
                    if (deque.peekLast() != '(') {
                        sb.append(deque.pollLast());
                    } else {
                        deque.pollLast();
                        for (int j = 0; j < sb.length(); j++) {
                            deque.addLast(sb.charAt(j));
                        }
                        break;
                    }
                }
            } else {
                deque.addLast(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) res.append(deque.pollFirst());
        return res.toString();
    }

}
