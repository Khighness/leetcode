package top.parak.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KHighness
 * @since 2021-05-15
 * @apiNote 1162. 地图分析
 */
public class T1162 {
    public int maxDistance(int[][] grid) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int height = grid.length, width = grid[0].length;
        // 寻找陆地
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        // 从各个陆地，一圈圈遍历海洋，最后的海洋就是最远的
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            // 将四周的海洋入队
            for (int i = 0; i < 4; i++) {
                int newX = x + dirs[i][0];
                int newY = y + dirs[i][1];
                if (newX < 0 || newY >= height || newY  < 0 || newY >= width || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1;
                hasOcean = true;
                queue.offer(new int[]{newX, newY});
            }
        }
        // 没有陆地或者没有海洋
        if (point == null || !hasOcean)
            return -1;
        // 最后一次遍历到的海洋的距离
        return grid[point[0]][point[1]] - 1;
    }
}
