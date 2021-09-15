package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-09
 * @apiNote 695. 岛屿的最大面积
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
