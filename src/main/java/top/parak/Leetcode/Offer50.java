package top.parak.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KHighness
 * @since 2021-09-14
 * @apiNote 剑指 Offer 50. 第一个只出现一次的字符
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : arr) {
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
