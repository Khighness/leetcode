package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-26
 * @apiNote 121. 买卖股票的最佳时机
 */
public class T121 {

    /**
     * 限定只能买一次
     * dp[i][j]表示第i天结束的时候，手上持股状态为j时，持有的现金数
     * j = 0，当前不持股，(1) 昨天也不持股 (2) 昨天持股今天卖出
     * j = 1，当前持股，(1) 昨天已经持股 (2) 昨天不持股，今天买入
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[n - 1][0];
    }

    /**
     * 空间优化
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[] dp = new int[2];
        dp[1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }

        return dp[0];
    }

}
