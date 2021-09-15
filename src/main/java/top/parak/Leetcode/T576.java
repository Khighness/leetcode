package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-15
 * @apiNote 576. 出界的路径数
 */
public class T576 {

    /**
     * dp[i][x][y]表示球移动i次之后位于坐标(x, y)的路径数量
     * 如果球移动了i次之后位于坐标(x, y)，移动了i + 1之后位于与(x, y)相邻的坐标(x', y')
     * 如果(x', y')没有出界，则dp[i + 1][x'][y'] += dp[i][x][y]
     * 否则，出界路径数量 += dp[i][x][y]
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = 1000000007;
        int[][] dirs  = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int ans = 0;
        int[][][] dp = new int[maxMove + 1][m][n];
        dp[0][startRow][startColumn] = 1;
        for (int i = 0; i < maxMove; i++) {
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    int count = dp[i][x][y];
                    if (count > 0) {
                        for (int[] dir : dirs) {
                            int newX = x + dir[0], newY = y + dir[1];
                            if (check(m, n, newX, newY)) {
                                dp[i + 1][newX][newY] = (dp[i + 1][newX][newY] + count) % MOD;
                            } else {
                                ans = (ans + count) % MOD;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    private boolean check(int m, int n, int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

}
