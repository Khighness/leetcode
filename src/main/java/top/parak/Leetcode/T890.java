package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author KHighness
 * @since 2021-07-18
 * @apiNote 890. 查找和替换模式
 */
public class T890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern))
                ans.add(word);
        }
        return ans;
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();
        char[] w = word.toCharArray();
        char[] p = pattern.toCharArray();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char x = w[i], y = p[i];
            if (m1.containsKey(x) && m1.get(x) != y || m2.containsKey(y) && m2.get(y) != x)
                return false;
            m1.put(x, y);
            m2.put(y, x);
        }
        return true;
    }

}
