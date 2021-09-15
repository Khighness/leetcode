package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-28
 * @apiNote 474. 一和零
 */
public class T474 {

    /**
     * 转换为背包问题，不同的是，这个题目有两种容量，0的容量m和1的容量n。
     * dp[i][j][k]表示输入字符在子区间[0, i]能够使用j个0和k个1的字符串的最大数量
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            int[] count = countOfZeroAndOne(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (count[0] <= j && count[1] <= k) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - count[0]][k - count[1]] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    public int[] countOfZeroAndOne(String str) {
        int[] count = new int[2];
        for (char ch : str.toCharArray()) {
            count[ch - '0']++;
        }
        return count;
    }

    /**
     * 只需要记录容量为多少时使用字符串的最大数量即可
     */
    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = countOfZeroAndOne(str);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(dp[i - count[0]][j - count[1]] + 1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

}
