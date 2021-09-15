package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-21
 * @apiNote 547. 省份数量
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
