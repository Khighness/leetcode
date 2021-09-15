package top.parak.Leetcode;

import java.util.Arrays;

/**
 * @author KHighness
 * @since 2021-05-13
 * @apiNote 279. 完全平方数
 */
public class T279 {

    /**
     * 完全背包问题
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

}
