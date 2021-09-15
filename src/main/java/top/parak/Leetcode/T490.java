package top.parak.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KHighness
 * @since 2021-08-21
 * @apiNote 490. 迷宫
 */
public class T490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = maze.length, n = maze[0].length;
        boolean[][] visit = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visit[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                return true;
            } else {
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    // 与传统迷宫不同，只有当撞墙时候才可以停止或者转向
                    while (check(m, n, x, y) && maze[x][y] == 0) {
                        x += dir[0];
                        y += dir[1];
                    }
                    if (!visit[x - dir[0]][y - dir[1]]) {
                        queue.add(new int[] {x - dir[0], y - dir[1]});
                        visit[x - dir[0]][y - dir[1]] = true;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(int m, int n, int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
