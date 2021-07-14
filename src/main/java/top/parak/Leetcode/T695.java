package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-09
 * @apiNote 695. 岛屿的最大面积
 */

/**
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * 一个岛屿是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 */
public class T695 {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int dfs = dfs(grid, r, c);
                    max = Math.max(max, dfs);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int r, int c) {
        // 边界
        if (!(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)) return 0;
        // 水域 | 已遍
        if (grid[r][c] != 1) return 0;
        // 标记
        grid[r][c] = 2;
        return 1 + dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
    }

}
