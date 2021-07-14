package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-04-07
 * @apiNote 516. 最长回文子序列
 */

/**
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 */
public class T516 {

    // dp[i][j]表示s[i-j]的最长回文子串长度
    // 状态转移：
    // (1) s[i] == s[j]  dp[i][j] = dp[i + 1][j - 1] + 2
    // (2) s[i] != s[j]  dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len <= 1) return 1;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
