package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-13
 * @apiNote 647. 回文子串
 */

/**
 * Problem:
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 */
public class T647 {
    /**
     * 动态规划
     * dp[i][j]表示字符串[i-j]位置是否为回文
     * (1) s[i] == s[j] && j - i <= 2, dp[i][j] = true
     * (2) s[i] == s[j] && j - i > 2, dp[i][j] = dp[i+1][j-1]
     * (3) s[i] != s[j], dp[i][j] = false
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 1) return 1;
        int len = s.length(), ans = len;
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++)
            dp[i][i] = true;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j && i < len - 1; i++) {
                if (arr[i] == arr[j]) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) ans++;
            }
        }
        return ans;
    }
}
