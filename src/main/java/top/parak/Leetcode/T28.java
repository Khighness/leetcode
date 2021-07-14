package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/28
 * @apiNote 28. 实现 strStr()
 */

/**
 * Problem:
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
public class T28 {
    public int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        } else {
            return -1;
        }
    }
}
