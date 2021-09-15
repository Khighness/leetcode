package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-17
 * @apiNote 1567. 乘积为正数的最长子数组长度
 */
public class T1567 {

    /**
     * 动态规划
     * dp[i][0]以nums[i]结尾的乘积为正数的最长子数组的长度
     * dp[i][0]以nums[i]结尾的乘积为负数的最长子数组的长度
     * 对于nums[i] > 0,
     * dp[i][0] = dp[i-1][0] + 1
     * dp[i-1][1] > 0 => dp[i][1] = dp[i-1][1] + 1
     * 对于nums[i] < 0
     * nums[i] < 0, dp[i][0] = dp[i-1][1] + 1
     * dp[i-1][1] < 0 => dp[i][1] = dp[i-1][0] + 1
     */
    public int getMaxLen(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        int ans = 0;
        if (nums[0] > 0) dp[0][0] = 1;
        if (nums[0] < 0) dp[0][1] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                dp[i][0] = dp[i-1][0] + 1;
                if (dp[i-1][1] > 0)
                    dp[i][1] = dp[i-1][1] + 1;
            }
            if (nums[i] < 0) {
                dp[i][1] = dp[i-1][0] + 1;
                if (dp[i-1][1] > 0)
                    dp[i][0] = dp[i-1][1] + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, dp[i][0]);
        }
        return ans;
    }

}
