package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-18
 * @apiNote 552. 学生出勤记录 II
 */
public class T552 {

    private int MOD = (int) 1e9 + 7;
    private int[][][] cache;

    public int checkRecord1(int n) {
        final int MOD = (int) (1e9+7);
        cache = new int[n + 1][2][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(n, 0, 0);
    }

    /**
     * 深搜
     *
     * @param u    当前还剩多少位需要决策
     * @param acnt 当前方案A的总出现次数
     * @param lcnt 当前方案中结尾L的连续出现次数
     */
    private int dfs(int u, int acnt, int lcnt) {
        if (acnt >= 2) return 0;
        if (lcnt >= 3) return 0;
        if (u == 0) return 1;
        if (cache[u][acnt][lcnt] != -1) {
            return cache[u][acnt][lcnt];
        }
        int ans = 0;
        ans = dfs(u - 1, acnt + 1, 0) % MOD;        // A
        ans = (ans + dfs(u - 1, acnt, lcnt + 1)) % MOD;   // L
        ans = (ans + dfs(u - 1, acnt, 0)) % MOD;           // P
        cache[u][acnt][lcnt] = ans;
        return ans;
    }

    /**
     * dp[i][j][k] 前i天，存在j天是缺席，且末尾k天同时是迟到的总情况
     * 状态转移
     * dp[]
     */
    public int checkRecord(int n) {
        final int MOD = (int) (1e9+7);
        return 0;
    }

}
