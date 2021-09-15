package top.parak.Leetcode;

import java.util.Stack;

/**
 * @author KHighness
 * @since 2020-10-01
 * @apiNote 1475. 商品折扣后的最终价格
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
