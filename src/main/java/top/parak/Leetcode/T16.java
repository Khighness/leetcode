package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author KHighness
 * @since 2021-07-15
 * @apiNote 16. 最接近的三数之和
 */
public class T16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; i++) {
            int l = i + 1, r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target)
                    r--;
                else if (sum < target)
                    l++;
                else
                    return ans;
            }
        }
        return ans;
    }
}
