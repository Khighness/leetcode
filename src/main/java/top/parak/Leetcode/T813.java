package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-27
 * @apiNote 813. 最大平均值和的分组
 */

import java.util.UUID;

/**
 * Problem:
 * 我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。
 * 注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。
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
