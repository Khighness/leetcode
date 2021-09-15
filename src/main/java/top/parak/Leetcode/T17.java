package top.parak.Leetcode;

import java.util.*;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 17. 电话号码的字母组合
 */
public class T17 {
    List<String> res = new ArrayList<>();
    String[] map = {"", "", "abc", "def", "ghi", "mno", "pqrs", "yuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null) return res;
        dfs(digits.toCharArray(), new StringBuilder(), 0);
        return res;
    }

    private void dfs(char[] arr, StringBuilder builder, int index) {
        if (index == arr.length) {
            res.add(builder.toString());
            return;
        }
        for (char c : map[arr[index] - '0'].toCharArray()) {
            // 选择
            builder.append(c);
            // 继续选择
            dfs(arr, builder, index + 1);
            // 撤销选择
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
