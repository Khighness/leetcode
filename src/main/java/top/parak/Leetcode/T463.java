package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-09
 * @apiNote 463. 岛屿的周长
 */

/**
 * Problem:
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 */
public class T463 {

    public int islandPerimeter(int[][] grid) {
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int nr = grid.length;
        int nc = grid[0].length;
        int ans = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 1) {
                    int len = 0;
                    for (int k = 0; k < dir.length; k++) {
                        int curR = r + dir[k][0], curC = c + dir[k][1];
                        if (curR == -1 || curR == nr) { // 上下
                            len++;
                        } else if (curC == -1 || curC == nc) { // 左右
                            len++;
                        } else if (curR >= 0 && curR <= nr - 1 && curC >= 0 && curC <= nc - 1 && grid[curR][curC] == 0) { // 中间
                            len++;
                        }
                    }
                    ans += len;
                }
            }
        }
        return ans;
    }

    public int islandPerimeter2(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {
        // 边界 + 1
        if (!(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)) return 1;
        // 水域 + 1
        if (grid[r][c] == 0) return 1;
        // 已遍 + 0
        if (grid[r][c] == 2) return 0;
        // 标记 已遍
        grid[r][c] = 2;
        return dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
    }

}
