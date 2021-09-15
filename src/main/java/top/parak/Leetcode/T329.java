package top.parak.Leetcode;

import com.sun.org.apache.regexp.internal.RE;
import sun.nio.ch.Net;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KHighness
 * @since 2021-08-14
 * @apiNote 329. 矩阵中的最长递增路径
 */
public class T329 {

    public int longestIncreasingPath2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] in = new int[m][n];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        // 计算入度
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                for (int[] dir : dirs) {
                    int newX = x + dir[0], newY = y + dir[1];
                    if (check(m, n, newX, newY) && matrix[x][y] > matrix[newX][newY]) {
                        in[x][y]++;
                    }
                }
                if (in[x][y] == 0) {
                    queue.add(new int[] {x, y});
                }
            }
        }
        int ans = 0;
        // 拓扑排序
        while (!queue.isEmpty()) {
            ans++;
            // 一层一层出队
            for (int i = queue.size(); i > 0; i--) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for (int[] dir : dirs) {
                    int newX = x + dir[0], newY = y + dir[1];
                    if (check(m, n, newX, newY) && matrix[x][y] < matrix[newX][newY]) {
                        if (--in[newX][newY] == 0) {
                            queue.add(new int[] {newX, newY});
                        }
                    }
                }
            }
        }
        return ans;
    }

    private boolean check(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
