package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-28
 * @apiNote 剑指 Offer 63. 股票的最大利润
 */

/**
 * Problem:
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
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
