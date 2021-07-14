package top.parak.Algorithm.Dynamic;

/**
 * @author KHighness
 * @since 2021-03-17
 * @apiNote [3/9].多重背包问题
 */

public class MultipleKnapsack {

    /**
     * 物品数组从索引为1的地方开始存值
     * @param capacity  背包容量
     * @param types     物品种数
     * @param number    物品数量
     * @param weight    物品重量
     * @param value     物品价值
     */
    public int solution(int capacity, int types, int[] number, int[] weight, int[] value) {
        int[] dp = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            dp[i] = 0;
        }
        for (int i = 1; i <= types; i++) {
            for (int j = capacity; j >= 0; j--) {
                for (int k = 0; k <= number[i] && k * weight[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
            }
        }
        return dp[capacity];
    }

}
