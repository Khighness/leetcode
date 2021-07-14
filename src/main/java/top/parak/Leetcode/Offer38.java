package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-04-04
 * @apiNote 剑指 Offer 38. 字符串的排列
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class Offer38 {
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        char[] array = s.toCharArray();
        process(array, 0, res);
        String[] ans = new String[res.size()];
        return res.toArray(ans);
    }

    public void process(char[] array, int index, List<String> list) {
        if (index == array.length) {
            list.add(String.valueOf(array));
        }
        boolean[] visit = new boolean[256];
        for (int j = index; j < array.length; j++) {
            if (!visit[array[j] - ' ']) {
                visit[array[j] - ' '] = true;
                swap(array, index, j);
                process(array, index + 1, list);
                swap(array, index, j);
            }
        }
    }

    private void swap(char[] str, int var1, int var2) {
        char temp = str[var1];
        str[var1] = str[var2];
        str[var2] = temp;
    }

}
