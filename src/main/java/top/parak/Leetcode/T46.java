package top.parak.Leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author KHighness
 * @since 2021-04-05
 * @apiNote 46. 全排列
 */
public class T46 {
    List<Integer> cur = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int i) {
        if (i == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            dfs(nums, i + 1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public List<List<Integer>> permute2(int[] nums) {
        dfs2(nums);
        return res;
    }

    private void dfs2(int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) continue;
            cur.add(nums[i]);
            dfs2(nums);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> permute3(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs3(nums, visited, 0);
        return res;
    }

    private void dfs3(int[] nums, boolean[] visited, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                cur.add(nums[i]);
                visited[i] = true;
                dfs3(nums, visited, index + 1);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }

}
