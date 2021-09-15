package top.parak.Practice.QAX;

/**
 * @author KHighness
 * @since 2021-08-07
 */
public class T2 {
    private boolean[][] visit;
    private int ans = 0;
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int getMaximumResource (int[][] grid) {
        visit = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0)
                    dfs(grid, i, j, 0);
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int i, int j, int cur) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (visit[i][j] || grid[i][j] == 0) {
            return;
        }
        visit[i][j] = true;
        cur += grid[i][j];
        ans = Math.max(ans, cur);
        for (int[] dir : dirs) {
            dfs(grid, i, j, cur);
        }
        visit[i][j] = false;
    }
}
