package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-29
 * @apiNote 880. 索引处的解码字符串
 */

import java.util.ArrayList;
import java.util.Stack;
import java.util.UUID;

/**
 * Problem:
 * 给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤：
 * 如果所读的字符是字母，则将该字母写在磁带上。
 * 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
 * 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
 */
public class T880 {
    // 内存超
    public String decodeAtIndex(String s, int k) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (res.length() >= k) {
                return res.charAt(k - 1) + "";
            }
            if ('2' <= c && c <= '9') {
                int count = c - '0';
                String cur = res.toString();
                for (int i = 0; i < count - 1; i++) {
                    res.append(cur);
                }
            } else {
                res.append(c);
            }
        }
        return res.charAt(k - 1) + "";
    }

    // 计算解码字符串的长度newLen，逆向遍历，当字符串的长度重复d次时，将字符串的长度减少到k/newLen
    public String decodeAtIndex2(String s, int k) {
        int len = s.length();
        long newLen = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if ('2' <= c && c <= '9') {
                newLen *= c - '0';
            } else {
                newLen++;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            char c = arr[i];
            k %= newLen;
            if (k == 0 && 'a' <= c && c <= 'z')
                return Character.toString(c);
            if ('2' <= c && c <= '9') newLen /= c - '0';
            else newLen--;
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new T880().decodeAtIndex("a2345678999999999999999", 1));
    }

}
