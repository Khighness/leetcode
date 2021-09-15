package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-29
 * @apiNote 837. 新21点
 */
public class T837 {

    /**
     * dp[x]表示从得分为x的情况下开始游戏并且获胜的概率
     * 从后往前递推，dp[0]即为所求
     * dp[x] = (dp[x+1] + dp[x+2] + ... + dp[x + w]) / w
     */
    public double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] dp = new double[K + W];
        for (int i  = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        for (int i = K - 1; i >= 0; i--) {
            for (int j = 1; j <= W; j++) {
                dp[i] += dp[i + j] / W;
            }
        }
        return dp[0];
    }

}
