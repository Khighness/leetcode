package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2021-05-12
 * @apiNote 120. 三角形最小路径和
 */
public class T120 {

    /**
     * 动态规划
     * dp[i][j]表示(i, j)到达三角形的底的最小路径
     * 注意：从三角形底下向上遍历，从下向上走，(i, j)的来源点只能有(i + 1, j)和(i + 1, j + 1)
     * 状态转移方程：dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] dp = new int[height][height];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = height - 1; i >= 0; i--) {
            List<Integer> curr = triangle.get(i);
            int width = curr.size();
            for (int j = 0; j < width; j++) {
                if (i == height - 1) { // 初始化
                    dp[i][j] = curr.get(j);
                } else { // 状态转移
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + curr.get(j);
                }
            }
        }
        return dp[0][0];
    }

}
