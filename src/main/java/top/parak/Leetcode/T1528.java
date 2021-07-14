package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/25 21:10
 * @apiNote 1528. 重新排列字符串
 */

/**
 * Problem:
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 */
public class T1528 {
    public String restoreString(String s, int[] indices) {
        int len = s.length();
        if (len == 1) return s;
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return new String(chars);
    }
}
