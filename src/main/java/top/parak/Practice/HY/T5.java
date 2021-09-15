package top.parak.Practice.HY;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KHighness
 * @since 2021-08-26
 * @apiNote 广搜
 */
public class T5 {
    static class P {
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            P p = ((P) obj);
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(x) + Integer.hashCode(y);
        }
    }

    private int m, n;
    private boolean[][] visit;
    private Set<P> ans;

    public int getExitCount (char[][] map) {
        // write code here
        int m = map.length, n = map[0].length;
        visit = new boolean[m][n];
        ans = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'S') {
                    dfs(map, i, j);
                }
            }
        }
        return ans.size();
    }

    private void dfs(char[][] map, int x, int y) {
        if (!(check(x, y)) || visit[x][y] || map[x][y] == 'X') {
            return;
        }
        if (map[x][y] == 'E') {
            ans.add(new P(x, y));
            return;
        }
        visit[x][y] = true;
        dfs(map, x + 1, y);
        dfs(map, x - 1, y);
        dfs(map, x, y + 1);
        dfs(map, x, y - 1);
    }

    private boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
