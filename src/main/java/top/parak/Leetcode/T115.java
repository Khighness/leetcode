package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-13
 * @apiNote 115. 不同的子序列
 */
public class T115 {

    /**
     * 动态规划
     * dp[i][j]表示t的前i个字符[0~i-1]与s的前j个字符[o~j-1]成功匹配的个数
     * 状态转移方程
     * (1) 若s[j-1] == t[i-1]  dp[i][j] = dp[i][j-1] + dp[i-1][j-1]
     * (1) 若s[j-1] != t[i-1]  dp[i][j] = dp[i][j-1]
     */
    public int numDistinct(String s, String t) {
        char[] arrT = t.toCharArray(), arrS = s.toCharArray();
        int lenT = arrT.length, lenS = arrS.length;
        int[][] dp = new int[lenT + 1][lenS + 1];
        for (int j = 0; j <= lenS; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= lenT; i++) {
            for (int j = 1; j <= lenS; j++) {
                dp[i][j] = dp[i][j - 1] +
                        (arrT[i - 1] == arrS[j - 1] ? dp[i - 1][j - 1] : 0);
            }
        }
        return dp[lenT][lenS];
    }

}
