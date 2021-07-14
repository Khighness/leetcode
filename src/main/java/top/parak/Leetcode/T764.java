package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-27
 * @apiNote 764. 最大加号标志
 */

import java.util.Arrays;

/**
 * Problem:
 *在一个大小在 (0, 0) 到 (N-1, N-1) 的2D网格 grid 中，除了在 mines 中给出的单元为 0，其他每个单元都是 1。
 * 网格中包含 1 的最大的轴对齐加号标志是多少阶？返回加号标志的阶数。如果未找到加号标志，则返回 0。
 * 一个 k" 阶由 1 组成的“轴对称”加号标志具有中心网格  grid[x][y] = 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。
 * 下面给出 k" 阶“轴对称”加号标志的示例。注意，只有加号标志的所有网格要求为 1，别的网格可能为 0 也可能为 1。
 */
public class T764 {
    /**
     * DP
     * dp[i][j][k](k=0,1,2,3)表示(i, j)在左,上,右,下四个方向上的臂长
     * 对于(i, j)的阶数 K = min(dp[i][j][0]， dp[i][j][1], dp[i][j+1][2], dp[i][j][3])
     */
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][][] dp = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] = 1;
                }
            }
        }
        for (int[] mine : mines) {
            for (int k = 0; k < 4; k++)
                dp[mine[0]][mine[1]][k] = 0;
        }
        // 计算左和上
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j][0] == 0) continue;
                dp[i][j][0] = dp[i][j - 1][0] + 1; // 左臂延伸
                dp[i][j][1] = dp[i - 1][j][1] + 1; // 上臂延伸
            }
        }
        // 计算右和下
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (dp[i][j][2] == 0) continue;
                dp[i][j][2] = dp[i][j + 1][2] + 1; // 右臂延伸
                dp[i][j][3] = dp[i + 1][j][3] + 1; // 右臂延伸
            }
        }
        // 计算阶数
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans,
                        min(dp[i][j][0], dp[i][j][1], dp[i][j][2],  dp[i][j][3]));
            }
        }
        return ans;
    }

    private int min(int a, int b, int c, int d) {
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }

    public static void main(String[] args) {
        System.out.println(new T764().orderOfLargestPlusSign(2, new int[][]{{0, 1}, {1, 0}, {1, 1}}));
    }

}
