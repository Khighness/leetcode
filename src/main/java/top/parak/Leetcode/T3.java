package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/19 20:23
 * @apiNote 3. 无重复字符的最长子串
 */

import java.util.HashMap;

/**
 * Problem:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串的长度。
 */

public class T3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        // 滑动窗口，每两个重复字母之间会形成移动窗口，计算窗口的最大值
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int left = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                /**
                 * 两种情况：
                 * ■代表窗口队列，●代表重复符号，最后一个●代表当前碰到的s.charAt(i)
                 * X = hashMap.get(s.charAt(i)) + 1, L = left
                 * 1、●(X) (L)■■■■■●    ==>   left = L
                 * 2、(L)■■■●(X)■■●     ==>   left = X
                 */
                left = Math.max(left, hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new T3().lengthOfLongestSubstring("abba"));
    }

}
