package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-25
 * @apiNote 486. 预测赢家
 */
public class T486 {
    /**
     * 甲乙比赛，甲先手区间[i...j]时，dp[i][j]表示甲对乙的净胜分。
     * 最终求的就是，甲先手面对区间[0...n-1]时，甲对乙的净胜分dp[0][n-1]是否>=0。
     * 甲先手面对区间[i...j]时：
     * (1) 如果甲拿nums[i]，那么变成乙先手面对区间[i+1...j]，
     * 这段区间内乙对甲的净胜分为dp[i+1][j]，那么甲对乙的净胜分就是nums[i]-dp[i+1][j]。
     * (2) 如果甲拿nums[j]，同理可得甲对乙的净胜分是nums[j]-dp[i][j-1]。
     * 两种情况取最大值即可。
     * dp[i][j] = max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]), i <= j
     * 那么i必须递减遍历，j必须递增遍历
     */
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        // 初始化
        for (int i = 0;  i < len; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }
}
