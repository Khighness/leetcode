package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-09
 * @apiNote 1254. 统计封闭岛屿的数目
 */

/**
 * Problem:
 * 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
 * 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 * 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 * 请返回封闭岛屿的数目。
 */
public class T1254 {
    int ans = 0;
    boolean touch = false;

    public int closedIsland(int[][] grid) {
        for (int r = 1; r < grid.length - 1; r++) {
            for (int c = 1; c < grid[0].length - 1; c++) {
                if (grid[r][c] == 0) {
                    ans++;
                    dfs(grid, r, c);
                    if (touch) {
                        ans--;
                        touch = false;
                    }
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int r, int c) {
        // 已遍历
        grid[r][c] = 2;
        // 触及『上|下|左|右』边界
        if (r == 0 || r == grid.length - 1 || c == 0 || c == grid[0].length - 1)
            touch = true;
        if (r - 1 >= 0 && grid[r - 1][c] == 0) dfs(grid, r - 1, c);
        if (c - 1 >= 0 && grid[r][c - 1] == 0) dfs(grid, r, c - 1);
        if (r + 1 < grid.length && grid[r + 1][c] == 0) dfs(grid, r + 1, c);
        if (c + 1 < grid[0].length && grid[r][c + 1] == 0) dfs(grid, r, c + 1);
    }

    public int closedIsland2(int[][] grid) {
        for (int r = 1; r < grid.length - 1; r++) {
            for (int c = 1; c < grid[0].length - 1; c++) {
                if (grid[r][c] == 0) {
                    if (dfs2(grid, r, c)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private boolean dfs2(int[][] grid, int r, int c) {
        // 边界（说明这一轮存在边界的岛屿）
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return false;
        // 水域
        if (grid[r][c] == 1) return true;
        // 已遍
        if (grid[r][c] == 2) return true;
        // 标记
        grid[r][c] = 2;
        boolean up = dfs2(grid, r - 1, c);
        boolean down = dfs2(grid, r + 1, c);
        boolean left = dfs2(grid, r, c - 1);
        boolean right = dfs2(grid, r, c + 1);
        return up && down && left && right;
    }
}
