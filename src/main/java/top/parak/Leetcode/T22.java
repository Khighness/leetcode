package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 22. 括号生成
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class T22 {

    /**
     * 动态规划
     * 知道所有 i < n时括号的可能生成排列，那么对于i = n
     * 遍历所有情况，p + q = i - 1, p取[0, ni- 1]
     * ( + 【i = p时的所有情况】 + ) + 【i = q时的所有情况】
     *
     */
    public List<String> generateParenthesis(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> list0 = new ArrayList<>();
        list0.add("");
        List<String> list1 = new ArrayList<>();
        list1.add("()");
        res.add(list0);
        res.add(list1);
        for (int i = 2; i < n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> p = res.get(j);
                List<String> q = res.get(i - 1 - j);
                for (String s1 : p) {
                    for (String s2 : q) {
                        cur.add('(' + s1 + ')' + s2);
                    }
                }
            }
            res.add(cur);
        }
        return res.get(n);
    }

    /**
     * DFS
     */
    public List<String> generateParenthesis2(int n) {
        List<String> cur = new ArrayList<>();
        return null;
    }

    private void dfs() {

    }
}
