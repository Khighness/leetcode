package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-22
 * @apiNote 剑指 Offer 47. 礼物的最大价值
 */
public class Offer47 {
    /**
     * dp[i][j]表示走到(i, j)的礼物最大累计价值
     * dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + grid[i][j]
     */
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
