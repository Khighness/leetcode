package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-14
 * @apiNote 1583. 统计不开心的朋友
 */
public class T1583 {
    /**
     * 创建二维数组order,
     * order[i][j]表示朋友j在i的朋友列表中的亲近程度下标。
     * 遍历preferences即可填入order中的全部元素的值。
     */
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] order = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                order[i][preferences[i][j]] = j;
            }
        }
        int[] match = new int[n];
        for (int[] pair : pairs) {
            match[pair[0]] = pair[1];
            match[pair[1]] = pair[0];
        }
        int ans = 0;
        for (int x = 0; x < n; x++) {
            int y = match[x];
            int index = order[x][y];
            for (int i = 0 ; i < index; i++) {
                int u = preferences[x][i];
                int v = match[u];
                if (order[u][x] < order[u][v]) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
