package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-30
 * @apiNote 面试题 17.09. 第 k 个数
 */

/**
 * Problem:
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
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
