package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-12
 * @apiNote 91. 解码方法
 */
public class T91 {

    /**
     * 动态规划
     * dp[i]表示s的前i个字符[i~i]的解码数量
     * 状态转移
     * (1) s[i] != 0 => dp[i] += dp[i-1]
     * (2) s[i-1] == 0 && s[i-1]s[i] <= 26 => dp[i] += dp[i-2]
     */
    public int numDecodings(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (arr[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            if (i >= 2 && arr[i - 2] != '0'
                    && (arr[i - 2] - '0') * 10 + (arr[i - 1] - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
