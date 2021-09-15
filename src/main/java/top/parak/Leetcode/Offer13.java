package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-18
 * @apiNote 剑指 Offer 13. 机器人的运动范围
 */
public class Offer13 {

    private int m;
    private int n;
    private int k;
    private int ans = 0;
    private boolean[][] visit;
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visit = new boolean[m][n];
        dfs(0, 0);
        return ans;
    }

    private void dfs(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n)
            return;
        if (visit[x][y] || digitSum(x) + digitSum(y) > k)
            return;
        visit[x][y] = true;
        ans++;
        for (int[] dir : dirs) {
            dfs(x + dir[0], y + dir[1]);
        }
    }

    private int digitSum(int val) {
        int sum = 0;
        while (val != 0) {
            sum += val % 10;
            val /= 10;
        }
        return sum;
    }

}
