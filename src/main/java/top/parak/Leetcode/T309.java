package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-25
 * @apiNote 309. 最佳买卖股票时机含冷冻期
 */
public class T309 {

    /**
     * 状态DP
     * j = 0: 不持股且没卖出
     * j = 1: 持股
     * j = 2: 持股且当天卖出
     */
     public int maxProfit(int[] prices) {
         int len = prices.length;
         int[][] dp = new int[len][3];
         dp[0][1] = -prices[0];
         for (int i = 1; i < len; i++) {
             // 不持股且没卖出：昨天不持股/昨天卖出
             dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
             // 持股：昨天持股/今天买入
             dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
             // 持股且卖出
             dp[i][2] = dp[i - 1][1] + prices[i];
         }
         return Math.max(dp[len - 1][0], dp[len - 1][2]);
     }

}
