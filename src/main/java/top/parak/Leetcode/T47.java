package top.parak.Leetcode;

import java.util.*;

/**
 * @author KHighness
 * @since 2021-05-22
 * @apiNote 47. 全排列 II
 */
public class T47 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> cur = new ArrayDeque<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, 0);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i >= 1 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            cur.addLast(nums[i]);
            visited[i] = true;
            dfs(nums, visited, index + 1);
            visited[i] = false;
            cur.removeLast();
        }
    }
}
