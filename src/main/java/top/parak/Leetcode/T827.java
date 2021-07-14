package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-09
 * @apiNote 827. 最大人工岛
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem:
 * 在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。
 * 进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）
 */
public class T827 {

    public int largestIsland(int[][] grid) {
        int index = 2; // 标记岛屿编号
        Map<Integer, Integer> map = new HashMap<>();
        int maxArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int curArea = dfs(grid, r, c, index);
                    map.put(index++, curArea);
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    maxArea = Math.max(maxArea, sea(grid, map, r, c));
                }
            }
        }
        return maxArea;
    }

    // 计算面积
    private int dfs(int[][] grid, int r, int c, int index) {
        // 边界
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return 0;
        // 水域 | 已遍
        if (grid[r][c] != 1) return 0;
        // 标记
        grid[r][c] = index;
        // 面积
        return 1 + dfs(grid, r - 1, c, index) + dfs(grid, r + 1, c, index) + dfs(grid, r, c - 1, index) + dfs(grid, r, c + 1, index);
    }

    // 改变海洋
    // (r, c)海洋坐标，修改为陆地后，可以联结上下左右的岛屿
    private int sea(int[][] grid, Map<Integer, Integer> map, int r, int c) {
        Set<Integer> set = new HashSet<>();
        int areaSum = 1;
        if (r - 1 >= 0              && grid[r - 1][c] != 0) set.add(grid[r - 1][c]);
        if (r + 1 < grid.length     && grid[r + 1][c] != 0) set.add(grid[r + 1][c]);
        if (c - 1 >= 0              && grid[r][c - 1] != 0) set.add(grid[r][c - 1]);
        if (c + 1 < grid[0].length  && grid[r][c + 1] != 0) set.add(grid[r][c + 1]);
        for (Integer index : set) {
            areaSum += map.get(index);
        }
        return areaSum;
    }

}
