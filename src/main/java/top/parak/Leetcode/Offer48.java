package top.parak.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KHighness
 * @since 2021-03-25
 * @apiNote Offer48. 最长不含重复字符的子字符串
 */
public class Offer48 {

    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int len = s.length();
        if (len <= 1) return len;
        int temp = -1, left = -1, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) { // 保证[temp+1, i]内无重复字符串
            char c = s.charAt(i);
            if (map.containsKey(c) && temp < map.get(c)) {
                temp = map.get(c);
            }
            map.put(c, i);
            if (i - temp > right - left) {
                right = i;
                left = temp;
            }
        }
        return right - left; // s.substring(left+1, right+1);
    }

    /**
     * 动态规划
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null) return 0;
        int len = s.length();
        if (len <= 1) return len;
        char[] arr = s.toCharArray();
        // 保存上一次字符出现的下标
        int[] last = new int[256];
        int[] dp = new int[len];
        // 基础位置
        for (int i = 0; i < 256; i++) {
            last[i] = -1;
        }
        last[arr[0] - ' '] = 0;
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = Math.min(dp[i - 1] + 1, i - last[arr[i] - ' ']);
            max = Math.max(max, dp[i]);
            last[arr[i] - ' '] = i;
        }
        return max;
    }

    /**
     * 简化
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s == null) return 0;
        int len = s.length();
        if (len <= 1) return len;
        char[] arr = s.toCharArray();
        int[] last = new int[256];
        for (int i = 0; i < 256; i++) {
            last[i] = -1;
        }
        int max = 1, preMax = 1;
        for (int i = 0; i < len; i++) {
            max = Math.min(preMax + 1, i - last[arr[i] - ' ']);
            preMax = max;
            last[arr[i] - ' '] = i;
        }
        return max;
    }
}
