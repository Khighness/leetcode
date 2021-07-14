package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-13
 * @apiNote 64. 最小路径和
 */

/**
 * Problem:
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class T64 {
    /**
     * 动态规划
     * dp[i][j]表示从(0, 0)到达(i, j)的最小路径和
     * 注意：对于任意一点(i, j)，来源点只有(i - 1, j)和(i, j - 1)
     * 状态转移方程：dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] += dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
