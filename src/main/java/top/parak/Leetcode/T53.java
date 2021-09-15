package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-10-17
 * @apiNote 53. 最大子序和
 */
public class T53 {

    public int maxSubArray(int[] nums) {
        int ans = nums[0], sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}
