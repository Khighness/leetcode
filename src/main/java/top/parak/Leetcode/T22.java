package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 22. 括号生成
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
        List<String> res = new ArrayList<>();
        dfs("", res, n, 0, 0);
        return res;
    }

    private void dfs(String cur, List<String> res, int n, int left, int right) {
        if (left > n || right > left) {
            return;
        }
        if (cur.length() == 2 * n) {
            res.add(cur);
            return;
        }
        dfs(cur + '(', res, n, left + 1, right);
        dfs(cur + ')', res, n, left, right + 1);
    }
}
