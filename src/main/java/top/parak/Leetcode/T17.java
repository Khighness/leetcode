package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 17. 电话号码的字母组合
 */

import java.util.*;

/**
 * Problem:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
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
