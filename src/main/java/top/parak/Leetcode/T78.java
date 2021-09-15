package top.parak.Leetcode;

import java.util.*;

/**
 * @author KHighness
 * @since 2021-05-22
 * @apiNote 78. 子集
 */
public class T78 {
    List<Integer> cur = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        res.add(new ArrayList<>(cur));
        for (int i = index; i < nums.length; i++) {
            //和上个数字相等就跳过
            if (i > index && nums[i] == nums[i - 1])
                continue;
            cur.add(nums[i]);
            dfs(nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

}
