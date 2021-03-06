package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author KHighness
 * @since 2020-11-27
 * @apiNote 15. 三数之和
 */
public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int l = i + 1, r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l+1]) l++; // 去重
                    while (l < r && nums[r] == nums[r-1]) r--; // 去重
                    l++;
                    r--;
                }
                else if (sum < 0)
                    l++;
                else
                    r--;
            }
        }
        return ans;
    }
}
