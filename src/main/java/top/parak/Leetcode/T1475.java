package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/1 14:26
 * @apiNote 1475. 商品折扣后的最终价格
 */

import java.util.Stack;

/**
 * Problem:
 * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 */
public class T1475 {

    // 暴力
    public int[] finalPrices1(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    res[i] = prices[i] - prices[j];
                    break;
                }
                res[i] = prices[i];
            }
        }
        res[prices.length - 1] = prices[prices.length - 1];
        return res;
    }

    // 使用栈
    public int[] finalPrices2(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.empty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                prices[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }
        return prices;
    }


}
