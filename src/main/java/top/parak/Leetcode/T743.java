package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-20
 * @apiNote 743. 网络延迟时间
 */

import java.util.UUID;

/**
 * Problem:
 * 有 n 个网络节点，标记为 1 到 n。
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 */
public class T743 {
    /**
     * Dijkstra
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        // 邻接矩阵
        int[][] matrix = new int[n][n];
        final int MAX_VALUE = Integer.MAX_VALUE >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = MAX_VALUE;
            }
        }
        for (int[] time : times) {
            matrix[time[0] - 1][time[1] - 1] = time[2];
        }
        int ans = 0, source = k - 1;
        // 是否访问
        boolean[] visited = new boolean[n];
        visited[source] = true;
        for (int i = 1; i < n; i++) {
            int min = MAX_VALUE;
            int index = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && matrix[source][j] < min) {
                    min = matrix[source][j];
                    index = j;
                }
            }
            if (index == -1) return -1;
            ans = Math.max(ans, min);
            visited[index] = true;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && matrix[source][index] + matrix[index][j] < matrix[source][j]) {
                    matrix[source][j] = matrix[source][index] + matrix[index][j];
                }
            }
        }
        return ans;
    }
}
