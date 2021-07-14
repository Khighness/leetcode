package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-05
 * @apiNote 200. 岛屿数量
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem:
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class T200 {

    // DFS
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    ans++;
                    dfs(grid, r, c);
                }
            }
        }
        return ans;
    }
    private void dfs(char[][] grid, int r, int c) {
        // 标记
        grid[r][c] = '0';
        if (r - 1 >= 0 && grid[r - 1][c] == 0) dfs(grid, r - 1, c);
        if (c - 1 >= 0 && grid[r][c - 1] == 0) dfs(grid, r, c - 1);
        if (r + 1 < grid.length && grid[r + 1][c] == 0) dfs(grid, r + 1, c);
        if (c + 1 < grid[0].length && grid[r][c + 1] == 0) dfs(grid, r, c + 1);
    }

    // BFS
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int ans = 0;
        for (int r = 0;  r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    ans++;
                    grid[r][c] = '0';
                    Queue<int[]> neighbors = new LinkedList<>();
                    neighbors.add(new int[] {r, c});
                    while (!neighbors.isEmpty()) {
                        int[] coor = neighbors.remove();
                        int x = coor[0], y = coor[1];
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            neighbors.add(new int[] {x - 1, y});
                            grid[x - 1][y] = '0';
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            neighbors.add(new int[] {x, y - 1});
                            grid[x][y - 1] = '0';
                        }
                        if (x + 1 < nr && grid[x + 1][y] == '1') {
                            neighbors.add(new int[] {x + 1, y});
                            grid[x + 1][y] = '0';
                        }
                        if (y + 1 < nc && grid[x][y + 1] == '1') {
                            neighbors.add(new int[] {x, y + 1});
                            grid[x][y + 1] = '0';
                        }
                    }
                }
            }
        }
        return ans;
    }
}
