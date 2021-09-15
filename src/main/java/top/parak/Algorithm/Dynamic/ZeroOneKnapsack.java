package top.parak.Algorithm.Dynamic;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-03-17
 * @apiNote 01背包
 * <p> 求组合数：外层for遍历物品，内层for遍历背包
 * <p> 求排列数：外层for遍历背包，内层for遍历物品
 */
public class ZeroOneKnapsack {

    /**
     * 二维数组实现
     * 物品数组从索引为1的地方开始存值
     * dp[i][j]表示背包容量为j时从[1-i]中选任意物品的最大价值
     * @param capacity  背包容量
     * @param types     物品种数
     * @param weight    物品重量
     * @param value     物品价值
     */
    public int solution1(int capacity, int types, int[] weight, int[] value) {
        int[][] dp = new int[types + 1][capacity + 1];
        for (int i = 0; i <= types; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= capacity; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= types; i++) {        // 当前商品
            for (int j = 1; j <= capacity; j++) { // 当前背包容量
                if (weight[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[types][capacity];
    }

    /**
     * 一维数组实现
     * 物品数组从索引为1的地方开始存值
     * @param capacity  背包容量
     * @param types     物品种数
     * @param weight    物品重量
     * @param value     物品价值
     */
    public int solution2(int capacity, int types, int[] weight, int[] value) {
        int[] dp = new int[capacity + 1]; // 只需要记录容量为多少时能存储的最大物品价值即可
        for (int i = 0; i <= capacity; i++) {
            dp[i] = 0;
        }
        for (int i = 1; i <= types; i++) {
            for (int j = capacity; j >= weight[i]; j--) {
                /**
                 * 为什么需要逆序遍历？
                 * (1) 过程分析
                 * 正序遍历：
                 * 比如，当i = 1(物品1重量为1，价值为2)时，
                 * j = 1时，dp[j] = max(dp[j-1], dp[j-v[i]]+w[i]) = max(dp[0], dp[0] + 2) = 2
                 * j = 2时，dp[j] = max(dp[j-1], dp[j-v[i]+w[i]]) = max(dp[1], dp[1] + 2) = 4
                 * 可以发现，容量充足时，物品1，被选择了超过1次
                 * 逆序遍历，直接从容量最大的背包开始，防止重复选择
                 * (2) 代码分析
                 * 从上面二维数组中可以看到dp[i][j]只依赖于dp[i][j-1]的值，逆序保证dp[i]只依赖于上一层的值
                 */
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[capacity];
    }

}
