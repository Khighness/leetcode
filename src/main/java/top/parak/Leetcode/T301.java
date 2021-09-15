package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author KHighness
 * @since 2021-09-13
 * @apiNote 301. 删除无效的括号
 */
public class T301 {
    // dfs过程中所有的合法的字符串
    private Set<String> all;
    // 左括号+1分，右括号-1分，最大得分
    private int max;
    // dfs过程中合法字符串的最大长度
    private int len;

    public List<String> removeInvalidParentheses(String s) {
        all = new HashSet<>();
        char[] arr = s.toCharArray();
        int l = 0, r = 0;
        for (char c : arr) {
            if (c == '(') l++;
            else if (c == ')') r++;
        }
        max = Math.min(l, r);
        dfs(arr, 0, 0, "");
        List<String> res = new ArrayList<>();
        for (String str : all) {
            if (str.length() >= len) {
                res.add(str);
            }
        }
        return res;
    }

    /**
     * @param arr    字符数组
     * @param index  决策位置
     * @param score  当前得分
     * @param cur    当前字符串
     */
    private void dfs(char[] arr, int index, int score, String cur) {
        if (index == arr.length) {
            if (score == 0 && cur.length() >= len) {
                len = cur.length();
                all.add(cur);
            }
            return;
        }
        if (arr[index] == '(') {
            if (score < max) { // 可以继续添加左括号
                dfs(arr, index + 1, score + 1, cur + '(');
            }
            dfs(arr, index + 1, score, cur);
        } else if (arr[index] == ')') {
            if (score > 0) { // 可以继续添加右括号
                dfs(arr, index + 1, score - 1, cur + ')');
            }
            dfs(arr, index + 1, score, cur);
        } else { // 其他字符，直接添加
            dfs(arr, index + 1, score, cur + arr[index]);
        }
    }
}
