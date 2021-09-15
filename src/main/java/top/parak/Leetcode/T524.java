package top.parak.Leetcode;

import java.util.List;

/**
 * @author KHighness
 * @since 2021-09-14
 * @apiNote 524. 通过删除字母匹配到字典里最长单词
 */
public class T524 {
    public String findLongestWord(String s, List<String> list) {
        list.sort((a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return a.compareTo(b);
        });
        int n = s.length();
        for (String str : list) {
            int m = str.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) == str.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == m) return str;
        }
        return "";
    }
}
