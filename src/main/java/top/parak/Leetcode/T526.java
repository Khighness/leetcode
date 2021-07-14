package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-28
 * @apiNote 526. 优美的排列
 */

/**
 * Problem:
 * 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
 * 第 i 位的数字能被 i 整除
 * i 能被第 i 位上的数字整除
 */
public class T526 {
    int ans = 0;
    public int countArrangement(int n) {
        boolean[] visit = new boolean[n + 1];
        dfs(visit, n, 1, ans);
        return ans;
    }

    private void dfs(boolean[] visit, int n, int index, int ans) {
        if (index == n + 1) {
            ans++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visit[i]) continue;
            if (i % index != 0 && index % i != 0) continue;
            visit[i] = true;
            dfs(visit, n, index + 1, ans);
            visit[i] = false;
        }
    }
}
