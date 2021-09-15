package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-27
 * @apiNote 746. 使用最小花费爬楼梯
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
