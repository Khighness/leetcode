package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-17
 * @apiNote 518. 零钱兑换 II
 */
public class T518 {

    /**
     * 动态规划，完全背包，不考虑排列顺序
     * dp[i]表示金额等于x的硬币组合数
     * 求组合数：外层for遍历物品，内层for遍历背包
     * 求排列数：外层for遍历背包，内层for遍历物品
     * 对于本题，就是外层遍历硬币，内层遍历金额
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount && i >= coin; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

}
