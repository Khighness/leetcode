package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-12
 * @apiNote 62. 不同路径
 */
public class T62 {

    /**
     * 动态规划
     * 状态：dp[i][j]表示从(0,0)的(j,j)的路径数量
     * 初始：dp[0][0] = 1 => 从(0, 0)到(0, 0)只能原地不动
     *      dp[i][0] = 1 => 从(0, 0)到(i, 0)只能一直向下
     *      dp[0][j] = 1 => 从(0, 0)到(0, j)只能一直向右
     * 状态转移：dp[i][j] = dp[i-1][j] + dp[i][j - 1] => 来到(i, j)要么是(i-1, j)要么是(i, j-1)
     */
    public int uniquePath(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 排列组合
     * <p>一共需要走(m + n - 2)步，向下(m - 1)，向左(n - 1)
     * 那么C(m-1, m+n-2) = (m+n-2)! / [(m-1)! * (n-1)!]
     *                  = (m+n-2) * (m+n-3) * ... * n / (m-1)!
     * </p>
     */
    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

    private long factorial(int x) {
        long res = 1;
        for (int i = 1; i <= x; i++) {
            res *= i;
        }
        return res;
    }
}
