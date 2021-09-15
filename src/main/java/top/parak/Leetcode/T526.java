package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-28
 * @apiNote 526. 优美的排列
 */
public class T526 {

    private int ans = 0;

    public int countArrangement(int n) {
        boolean[] visit = new boolean[n + 1];
        dfs(visit, n, 1);
        return ans;
    }

    private void dfs(boolean[] visit, int n, int index) {
        if (index == n + 1) {
            ans++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visit[i]) continue;
            if (i % index != 0 && index % i != 0) continue;
            visit[i] = true;
            dfs(visit, n, index + 1);
            visit[i] = false;
        }
    }

}
