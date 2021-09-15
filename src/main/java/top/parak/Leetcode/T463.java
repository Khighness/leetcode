package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-09
 * @apiNote 463. 岛屿的周长
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
