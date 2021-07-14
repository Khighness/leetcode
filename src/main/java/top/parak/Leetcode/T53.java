package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/10/17
 * @apiNote 53. 最大子序和
 */

/**
 * Problem:
 *
 */
public class T53 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
