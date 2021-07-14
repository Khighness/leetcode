package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-22
 * @apiNote 40. 组合总和 II
 */

import java.util.*;

/**
 * Problem:
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 */
public class T40 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> cur = new ArrayDeque<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    // 排序剪枝
    private void dfs(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (start == candidates.length) return;
        // 选择
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            // 重复跳过
            if (i != start && candidates[i] == candidates[i - 1]) continue;
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1);
            cur.removeLast();
        }
    }
}
