package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author KHighness
 * @since 2021-05-17
 * @apiNote 491. 递增子序列
 */

/**
 * Problem:
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。
 */
public class T491 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, -1, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> cur) {
        if (cur.size() > 1)
            res.add(new ArrayList<>(cur));
        Set<Integer> set = new HashSet<>();
        for (int i = index + 1; i < nums.length; i++) {
            if (set.contains(nums[i]))
                continue;
            // 选择
            set.add(nums[i]);
            if (index == -1 || nums[i] >= nums[index]) {
                cur.add(nums[i]);
                // 继续搜索
                dfs(nums, i, cur);
                // 撤销选择
                cur.remove(cur.size() - 1);
            }
        }
    }

    List<Integer> curr = new ArrayList<>();

    public List<List<Integer>> findSubsequences2(int[] nums) {
        if (nums == null) return null;
        dfs(0, Integer.MIN_VALUE, nums);
        return res;
    }

    private void dfs(int index, int prev, int[] nums) {
        if (index >= nums.length) {
            if (curr.size() >= 2) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        // 递增，选择
        if (nums[index] >= prev) {
            curr.add(nums[index]);
            dfs(index + 1, nums[index], nums);
            curr.remove(curr.size() - 1);
        }
        // 去重，不选择
        if (nums[index] != prev) {
            dfs(index + 1, prev, nums);
        }
    }
}
