package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-27
 * @apiNote 746. 使用最小花费爬楼梯
 */

/**
 * Problem:
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 */
public class T746 {
    /**
     * dp[i]表示从第i层阶梯到达顶楼的最小化费
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[len - 1] = cost[len - 1];
        dp[len - 2] = cost[len - 2];
        for (int i = len - 3; i >= 0; i--) {
            dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }
}
