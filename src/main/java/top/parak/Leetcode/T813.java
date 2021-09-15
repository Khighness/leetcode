package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-27
 * @apiNote 813. 最大平均值和的分组
 */
public class T813 {

    /**
     * 动态规划
     * dp[i][k]前i个元素包含分成k份，所能得到的最大分数
     * dp[i][k] = Math.max(dp[i][k], dp[j][k-1] + (A[j+1]~A[i])/(i-j))
     */
    public double largestSumOfAverages(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        double[] preSum = new double[len + 1];
        for (int i = 1; i <= len; i++) { // 前缀和
            preSum[i] += preSum[i-1] + nums[i-1];
        }
        double[][] dp = new double[len+1][k+1];
        for (int i = 1; i <= len; i++) { // 前i个元素分1份
            dp[i][1] = preSum[i] / i;
        }
        for (int i = 1; i <= len; i++) {
            for (int a = 2; a <= k; a++) {
                for (int j = a - 1; j < i; j++) { // 前j个元素分a-1份，i-j个元素分1份
                    dp[i][a] = Math.max(dp[i][a], dp[j][a-1] + (preSum[i] - preSum[j]) / (i - j));
                }
            }
        }
        return dp[len][k];
    }

}
