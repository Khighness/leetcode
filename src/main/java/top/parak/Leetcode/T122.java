package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-26
 * @apiNote 122. 买卖股票的最佳时机 II
 */
public class T122 {

    /**
     * 状态DP
     * dp[i][j]表示到第i天结束时，状态为j时，手上拥有的最大现金数
     * j = 0，表示持有现金
     * j = 1，表示持有股票
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][] dp = new int[len][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    /**
     * 优化空间
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int cash = 0, hold = -prices[0];
        int preCash = cash, preHold = hold;
        for (int i = 1; i < len; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }

}
