package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-23
 * @apiNote 1234. 替换子串得到平衡字符串
 */

import java.util.Arrays;

/**
 * Problem:
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 * 请返回待替换子串的最小可能长度。
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 */
public class T1234 {
    /**
     * 滑动窗口
     */
    public int balancedString(String s) {
        if (s == null || s.length() <= 0)
            return -1;
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] need = new int[26];
        int[] curr = new int[26];
        Arrays.fill(need,- n / 4);
        for (char c : arr) {
            need[c-'A']++;
        }
        // 多余字符
        int needCount = 0;
        for (int value : need) {
            if (value > 0) {
                needCount++;
            }
        }
        if (needCount == 0)
            return 0;

        // 滑动窗口
        int l = 0, r = 0;
        // 记录结果，匹配数量
        int ans = n, matchCount = 0;

        while (r < n) {
            char c = arr[r];
            // 说明当前字符多余
            if (need[c - 'A'] > 0) {
                curr[c - 'A']++;
                if (curr[c - 'A'] == need[c - 'A']) {
                    matchCount++;
                }
            }
            while (l <= r && matchCount == needCount) {
                ans = Math.min(ans, r - l + 1);
                char cl = arr[l];
                if (need[cl - 'A'] > 0) {
                    curr[cl - 'A']--;
                    if (curr[cl - 'A'] < need[cl - 'A']) {
                        matchCount--;
                    }
                }
                l++;
            }
            r++;
        }
        return ans;
    }
}
