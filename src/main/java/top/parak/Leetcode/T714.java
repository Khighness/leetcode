package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-26
 * @apiNote 714. 买卖股票的最佳时机含手续费
 */
public class T714 {
    /**
     * 状态DP
     * j = 0，持有现金
     * j = 1，持有股票
     */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][] dp = new int[len][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
