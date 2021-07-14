package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-22
 * @apiNote 39. 组合总和
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Problem:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 */
public class T39 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> cur = new ArrayDeque<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (start == candidates.length) return;
        // 选，下次还从start开始，表示可以重复
        if (target - candidates[start] >= 0) {
            cur.addLast(candidates[start]);
            dfs(candidates, target - candidates[start], start);
            cur.removeLast();
        }
        // 不选
        dfs(candidates, target, start + 1);
    }

    private void dfs2(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            cur.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], start);
            cur.removeLast();
        }
    }
}
