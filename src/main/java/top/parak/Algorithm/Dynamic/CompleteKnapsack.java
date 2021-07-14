package top.parak.Algorithm.Dynamic;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-03-17
 * @apiNote [2/9].完全背包
 */

public class CompleteKnapsack {

    /**
     * 物品数组从索引为1的地方开始存值
     * @param capacity  背包容量
     * @param types     物品种数
     * @param weight    物品重量
     * @param value     物品价值
     */
    public int solution(int capacity, int types, int[] weight, int[] value) {
        int[] dp = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            dp[i] = 0;
        }
        for (int i = 1; i <= types; i++) {
            for (int j = capacity; j >= 0; j--) {
                for (int k = 0; k <= j / weight[i]; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
            }
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int types = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] weight = new int[types + 1];
        int[] value = new int[types + 1];
        for (int i = 1; i <= types; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }
        ZeroOneKnapsack zeroOneKnapsack = new ZeroOneKnapsack();
        int ans = zeroOneKnapsack.solution2(capacity, types, weight, value);
        System.out.println(ans);
    }
}
