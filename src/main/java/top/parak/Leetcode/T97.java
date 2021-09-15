package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-13
 * @apiNote 97. 交错字符串
 */
public class T97 {
    /**
     * 动态规划
     * dp[i][j]表示s1的前i个字符(0~i-1)和s2的前j个字符(0~i-1)能否构成s3的前i+j个字符
     * 状态转移方程：dp[i][j] = (dp[i-1][j] && s1[i-1] == s3[i+j-1]) || (dp[i][j-1] && s2[j-1] == s3[i+j-1])
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int len1 = c1.length, len2 = c2.length, len3 = c3.length;
        if (len1 + len2 != len3) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i - 1 >= 0)
                    dp[i][j] = dp[i][j] || dp[i - 1][j] && c1[i - 1] == c3[i + j - 1];
                if (!dp[i][j] && j - 1 >= 0)
                    dp[i][j] = dp[i][j] || dp[i][j - 1] && c2[j - 1] == c3[i + j - 1];
            }
        }
        return dp[len1][len2];
    }
}
