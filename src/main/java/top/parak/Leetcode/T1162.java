package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-15
 * @apiNote 1162. 地图分析
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem:
 * 你现在手里有一份大小为 N x N 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 。
 * 如果网格上只有陆地或者海洋，请返回 -1。
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
