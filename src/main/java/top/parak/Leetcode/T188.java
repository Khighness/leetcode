package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-26
 * @apiNote 188. 买卖股票的最佳时机 IV
 */
public class T188 {
    /**
     * k次限制
     * dp[i][j]
     * j = 0 无操作
     * j = 2 * k - 1，第k次买入
     * j = 2 * k，第k次卖出
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int[][] dp = new int[n][1 + 2 * k];
        for (int j = 1; j < 2 * k; j += 2) {
            dp[0][j] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 2 * k; j++) {
                if (j % 2 == 1) { // 买入
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else { // 卖出
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }
        return dp[n - 1][2 * k];
    }
}
