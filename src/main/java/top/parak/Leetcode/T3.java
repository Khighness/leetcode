package top.parak.Leetcode;

import java.util.HashMap;

/**
 * @author KHighness
 * @since 2020-09-19
 * @apiNote 3. 无重复字符的最长子串
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

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int temp = -1;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (map.containsKey(c)) {
                temp = Math.max(temp, map.get(c));
            }
            if (i - temp > right - left) {
                right = i;
                left = temp;
            }
            map.put(c, i);
        }
        return right - left;
    }

}
