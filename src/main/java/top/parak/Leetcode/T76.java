package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-23
 * @apiNote 76. 最小覆盖子串
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
public class T76 {

    /**
     * 滑动窗口 + 欠账表
     */
    public String minWindow(String s, String t) {
        // 欠账表
        int needCount = t.length();
        int[] count = new int[128];
        char[] arrS = s.toCharArray();
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        // 滑动窗口
        int l = 0, r = 0, n = arrS.length;
        // 记录结果
        int start = 0, size = Integer.MAX_VALUE;
        while (r < n) {
            char c = arrS[r];
            // 必须字符
            if (count[c] > 0) {
                needCount--;
            }
            count[c]--;
            // 还清账，收缩左指针
            // 左指针再走右指针走过的路，等于0的表示必须字符，小于0的表示非必须字符
            if (needCount == 0) {
                while (l < r && count[arrS[l]] < 0) {
                    count[arrS[l]]++;
                    l++;
                }
                if (r - l + 1 < size) {
                    start = l;
                    size = r - l + 1;
                }
                count[arrS[l]]++;
                l++;
                needCount++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

}
