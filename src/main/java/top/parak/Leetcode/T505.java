package top.parak.Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KHighness
 * @since 2021-08-21
 */
public class T505 {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = maze.length, n = maze[0].length;
        int[][] dist = new int[m][n];
        for (int[] dir : dist) {
            Arrays.fill(dir, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            for (int[] dir: dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                int count = 0;
                while (check(m, n, x, y) && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if (dist[cur[0]][cur[1]] + count < dist[x - dir[0]][y - dir[1]]) {
                    dist[x - dir[0]][y - dir[1]] = dist[cur[0]][cur[1]] + count;
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                }
            }
        }
        return dist[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : dist[dest[0]][dest[1]];
    }

    private boolean check(int m, int n, int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
