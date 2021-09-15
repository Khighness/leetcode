package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-30
 * @apiNote 650. 只有两个键的键盘
 */
public class T650 {

    /**
     * 动态规划
     * dp[i]表示得到i个A需要操作的次数
     * 状态转移
     * dp[i] = dp[i的最大因子] + 1(copy) + (i - k) / k(paste);
     */
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int k = i / 2; k > 0; k--) {
                if (i % k == 0) {
                    dp[i] = dp[k] + 1 + (i - k) / k;
                    break;
                }
            }
        }
        return dp[n];
    }

}
