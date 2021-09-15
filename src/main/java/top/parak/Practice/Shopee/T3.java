package top.parak.Practice.Shopee;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KHighness
 * @since 2021-07-19
 */
public class T3 {
    /**
     * 滑动窗口 + 欠账表
     */
    public String findMinOverrideSubString(String source, String target) {
        // write code here
        int start = 0, size = Integer.MAX_VALUE;
        int left = 0, right, len = source.length();
        int needCount = target.length();
        int[] count = new int[256];
        char[] src = source.toCharArray();
        char[] tar = target.toCharArray();
        for (char c : tar) {
            count[c]++;
        }
        // 向右扩张
        for (right = 0; right < len; right++) {
            char c = src[right];
            // 必须字符
            if (count[c] > 0)
                needCount--;
            count[c]--;

            // 左边收缩
            if (needCount == 0) {
                // 直到碰到必须字符
                while (left < right && count[src[left]] < 0) {
                    count[src[left]]++;
                    left++;
                }
                if (right - left + 1 < size) {
                    start = left;
                    size = right - left + 1;
                }
                left++;
                needCount++;
                count[src[left]]++;
            }
        }
        return size == Integer.MAX_VALUE ? "" : source.substring(start, start + size);
    }

    public String findMinOverrideSubString2(String source, String target) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] tar = target.toCharArray();
        for (char c : tar) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0, start = 0;
        int len = Integer.MAX_VALUE;
        int size = source.length();
        char[] arr = source.toCharArray();
        while (right < size) {
            char c = arr[right];
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = arr[left];
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.getOrDefault(d, 1) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : source.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println(new T3().findMinOverrideSubString2("abcd", "bc"));
    }
}
