package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-13
 * @apiNote 70. 爬楼梯
 */

/**
 * Problem:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 */
public class T70 {
    /**
     * 动态规划
     * 爬上n阶梯的方法数量
     * (1) 爬上(n-1)阶梯，再爬一步
     * (2) 爬上(n-2)阶梯，再爬两步
     * 因此：dp[n] = dp[n-1] + dp[n-2]
     */
    public int climbStairs(int n) {
        int dp_1 = 1, dp_2 = 2;
        if (n == 1) return dp_1;
        if (n == 2) return dp_2;
        for (int i = 3; i <= n; i++) {
            int temp = dp_2;
            dp_2 = dp_1 + dp_2;
            dp_1 = temp;
        }
        return dp_2;
    }
}
