package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-04-05
 * @apiNote 46. 全排列
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem:
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class T46 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> cur = new ArrayDeque<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) continue;
            cur.addLast(nums[i]);
            dfs(nums);
            cur.removeLast();
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs2(nums, visited, 0);
        return res;
    }

    private void dfs2(int[] nums, boolean[] visited, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                cur.addLast(nums[i]);
                visited[i] = true;
                dfs2(nums, visited, index + 1);
                cur.removeLast();
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute3(int[] nums) {
        dfs3(nums, 0);
        return res;
    }

    private void dfs3(int[] nums, int i) {
        if (i == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            dfs3(nums, i + 1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] arr, int var1, int var2) {
        int temp = arr[var1];
        arr[var1] = arr[var2];
        arr[var2] = temp;
    }

}
