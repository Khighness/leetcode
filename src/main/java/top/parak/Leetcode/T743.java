package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-20
 * @apiNote 743. 网络延迟时间
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
