package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-23
 * @apiNote 1328. 破坏回文串
 */

/**
 * Problem:
 * 给你一个回文字符串 palindrome ，请你将其中 一个 字符用任意小写英文字母替换，使得结果字符串的字典序最小，且 不是 回文串。
 * 请你返回结果字符串。如果无法做到，则返回一个空串。
 */
public class T1328 {
    /**
     * 将回文串分为前半段和后半段，
     * 在前半段中，遇到不为a的字符修改为a返回
     * 前半段字符都为a，那么将后半段最后一个字符改为b
     */
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length(), half = (len - 2) >> 1;
        if (len < 2) return "";
        char[] arr = palindrome.toCharArray();
        for (int i = 0; i <= half; i++) {
            if (arr[i] > 'a') {
                arr[i] = 'a';
                return new String(arr);
            }
        }
        arr[len - 1] = 'b';
        return new String(arr);
    }
}
