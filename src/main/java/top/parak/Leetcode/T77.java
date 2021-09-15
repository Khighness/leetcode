package top.parak.Leetcode;

import java.util.*;

/**
 * @author KHighness
 * @since 2021-05-22
 * @apiNote 77. 组合
 */
public class T77 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> cur = new ArrayDeque<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) return res;
        dfs(n, k, 1);
        return res;
    }

    private void dfs(int n, int k, int start) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        // 剪枝，凑不齐k个数
        for (int i = start; i <= n - (k - cur.size() - 1); i++) {
            cur.addLast(i);
            dfs(n, k, i + 1);
            cur.removeLast();
        }
    }

}
