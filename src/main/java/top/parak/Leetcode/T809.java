package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 809. 情感丰富的文字
 */
public class T809 {

    public int expressiveWords(String s, String[] words) {
        List<Object[]> target = wordAndCount(s);
        int ans = 0;
        for (String word : words) {
            List<Object[]> list = wordAndCount(word);
            if (target.size() != list.size()) continue;
            int index;
            // 同一段字符相同，目标字符串与原始字符串相同或者目标字符串的长度大于3才能扩张
            for (index = 0; index < target.size(); index++) {
                Object[] ob1 = target.get(index), ob2 = list.get(index);
                char c1 = (char) ob1[0], c2 = (char) ob2[0];
                int count1 = (int) ob1[1], count2 = (int) ob2[1];
                if (c1 != c2) break;
                if (count1 < count2) break;
                if (count1 != count2 && count1 < 3) break;
            }
            if (index == target.size()) ans++;
        }
        return ans;
    }

    // 将相邻字母相同的一段字符串划分为一段，统计字符和数量
    private List<Object[]> wordAndCount(String str) {
        List<Object[]> list = new ArrayList<>();
        int i = 0, len = str.length();
        char[] arr = str.toCharArray();
        while (i < len) {
            char c = arr[i];
            int count = 0;
            while (i < len && arr[i] == c) {
                count++;
                i++;
            }
            list.add(new Object[]{c, count});
        }
        return list;
    }

}
