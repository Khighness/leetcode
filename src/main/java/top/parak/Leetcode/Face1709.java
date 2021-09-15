package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-30
 * @apiNote 面试题 17.09. 第 k 个数
 */
public class Face1709 {
    public int getKthMagicNumber(int k) {
        int k3 = 0, k5 = 0, k7 = 0;
        int[] dp = new int[k];
        dp[0] = 1;
        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(dp[k3] * 3, Math.min(dp[k5] * 5, dp[k7] * 7));
            if (dp[i] == dp[k3] * 3) k3++;
            if (dp[i] == dp[k5] * 5) k5++;
            if (dp[i] == dp[k7] * 7) k7++;
        }
        return dp[k-1];
    }
}
