package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author KHighness
 * @since 2021-07-18
 * @apiNote 187. 重复的DNA序列
 */
public class T187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        List<String> ans = new ArrayList<>();
        if (len <= 10) return ans;
        Set<String> first = new HashSet<>();
        Set<String> second = new HashSet<>();
        for (int i = 0; i < len - 10 + 1; i++) {
            String substring = s.substring(i, i + 10);
            if (first.contains(substring))
                second.add(substring);
            else
                first.add(substring);
        }
        return new ArrayList<>(second);
    }
}
