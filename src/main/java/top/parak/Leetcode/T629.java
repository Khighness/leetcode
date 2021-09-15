package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-25
 * @apiNote 629. K个逆序对数组
 */

public class T629 {

    /**
     * f(i, j) 表示数字 [1 .. i] 的排列中恰好包含 j 个逆序对的个数
     * f(i, j) = f(i, j - 1) + f(i - 1, j) - f(i - 1, j - i)
     */
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        int M = 1000000007;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k && j <= i * (i - 1) / 2; j++) {
                if (i == 1) {
                    dp[i][j] = 1;
                    break;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    int val = (dp[i - 1][j] + M - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % M;
                    dp[i][j] = (dp[i][j - 1] + val) % M;
                }
            }
        }
        return dp[n][k];
    }

}
