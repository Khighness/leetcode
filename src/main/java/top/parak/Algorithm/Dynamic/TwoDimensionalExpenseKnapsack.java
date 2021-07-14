package top.parak.Algorithm.Dynamic;

/**
 * @author KHighness
 * @since 2021-03-17
 * @apiNote [4/9].二维费用背包
 */

public class TwoDimensionalExpenseKnapsack {

    /**
     * 物品数组从索引为1的地方开始存值
     * @param capacity  背包容量
     * @param types     物品种数
     * @param weight    物品重量
     * @param value     物品价值
     */
    public int solution2(int capacity, int types, int[] weight, int[] value) {
        int[] dp = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            dp[i] = 0;
        }
        for (int i = 1; i <= types; i++) {
            for (int j = capacity; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[capacity];
    }

}
