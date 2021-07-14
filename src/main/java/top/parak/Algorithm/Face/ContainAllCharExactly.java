package top.parak.Algorithm.Face;

import java.util.Arrays;

/**
 * @author KHighness
 * @since 2021-03-16
 * @apiNote 给定字符串aim，在str中找到一个与aim长度相同，包含字符种类和数量相同的字符串，
 * 返回任意满足条件的一个子串的起始位置，未找到返回-1。
 */

public class ContainAllCharExactly {

    /**
     * 暴力搜索
     */
    public int solution1(String s, String a) {
        if (s == null || a == null || s.length() < a.length()) {
            return -1;
        }
        char[] aim = a.toCharArray();
        int len = aim.length;
        Arrays.sort(aim);
        String aimSort = String.valueOf(aim);

        for (int i = 0; i < s.length(); i++) {
            char[] cur = s.substring(i, i + len).toCharArray();
            Arrays.sort(cur);
            String curSort = String.valueOf(cur);
            if (curSort.equals(aimSort)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 滑动窗口 + 欠债表
     */
    public int solution2(String s, String a) {
        char[] str = s.toCharArray();
        char[] aim = a.toCharArray();
        int[] count = new int[256];
        // m滑动窗口长度
        int len = aim.length;
        // 欠债表
        for (char c : aim) {
            count[c]++;
        }
        // 遍历索引
        int i = 0;
        // 无效点数
        int invalidTimes = 0;
        // 第一个滑动窗口
        for (; i < len; i++) {
            if (count[str[i]]-- <= 0) {
                invalidTimes++;
            }
        }
        for (; i < str.length; i++) {
            if (invalidTimes == 0) {
                return i - len;
            }
            if (count[str[i]]-- <= 0) { // 右边字符进窗口，如果进窗口之前已经是0，表示是无效字符
                invalidTimes++;
            }
            if (count[str[i - len]]++ < 0) { // 左边字符出窗口，如果出窗口之前欠债表小于0，说明是无效字符
                invalidTimes--;
            }
        }
        return invalidTimes == 0 ? i - len : -1;
    }

}
