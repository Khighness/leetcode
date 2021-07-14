package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-21
 * @apiNote 547. 省份数量
 */

/**
 * Problem:
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 */
public class T547 {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                ans++;
                visited[i] = true;
                dfs(isConnected, visited, i);
            }
        }
        return ans;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int curr) {
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[curr][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(isConnected, visited, i);
            }
        }
    }

}
