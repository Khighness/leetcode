package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-11-28
 * @apiNote 28. 实现 strStr()
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
