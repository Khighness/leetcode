package top.parak.Practice.HY;

/**
 * @author KHighness
 * @since 2021-08-26
 * @apiNote 区间DP
 */
public class T3 {
    public int predictOrder (int[] nums) {
        // write code here
        int len = nums.length, max1 = 0, max2 = 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j],  nums[j] - dp[i][j - 1]);
            }
        }
        if (dp[0][len - 1] == 0) return 0;
        return dp[0][len - 1] > 0 ? 1 : -1;
    }
}
