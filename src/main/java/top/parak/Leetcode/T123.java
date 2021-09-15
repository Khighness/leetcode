package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-26
 * @apiNote 123. 买卖股票的最佳时机 III
 */
public class T123 {

    /**
     * dp[i][j]表示第i天结束，状态为j时持有现金
     * j = 0 无操作
     * j = 1 第一次买入
     * j = 2 第一次卖出
     * j = 3 第二次买入
     * j = 4 第二次卖出
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int[][] dp = new int[n][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[n- 1][4];
    }

}
