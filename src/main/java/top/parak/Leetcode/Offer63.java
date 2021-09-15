package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-28
 * @apiNote 剑指 Offer 63. 股票的最大利润
 */
public class Offer63 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int minPrice = prices[0], maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

}
