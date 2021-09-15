package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-30
 * @apiNote 72.编辑距离
 */
public class T72 {

    /**
     * 递归（自顶向下），超时
     * 算法流程，dp(i, j)
     * 用i指向word1的当前索引，用j指向word2指向word2的当前索引
     * 那么对于word1[i]与word2[j]，有两种情况
     * （1）word1[i] == word2[j] => dp(i, j) = dp(i - 1, j - 1)
     *     此时直接跳过，让i和j都前移一位即可
     * （2）word1[i] != word2[j]
     *     此时可以对word1进行三种操作，操作完毕后操作次数需要+1
     *     （2.1）插入 => dp(i, j) = dp(i, j - 1) + 1
     *           在word1的i+1位置插入一个与word2[j]相同的字符，此时j会被匹配
     *           然后i不动，j前移一位即可
     *     （2.2）删除 => dp(i, j) = dp(i - 1, j) + 1
     *           删除word1[i]，然后i指针前移一位即可
     *     （2.3）替换 => dp(i, j) = dp(i - 1, j - 1) + 1
     *           将word1[i]替换为word2[j]，此时j会被匹配
     *           然后让i和j均前移一位即可
     * 终止条件
     * （1）i == -1，代表word1走完了，后续的只需要用插入操作将word1补充为word2，需要插入(j + 1)个字符
     * （2）j == -1，代表word2走完了，后续的只需要用删除操作将word1删减为word2，需要删除(i + 1)个字符
     */
    public int minDistance(String word1, String word2) {
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        return dp(ch1, ch2, word1.length() - 1, word2.length() - 1);
    }

    public int dp(char[] ch1, char[] ch2, int i, int j) {
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;
        if (ch1[i] == ch2[j]) {
            return dp(ch1, ch2, i- 1, j - 1);
        } else {
            return Math.min(dp(ch1, ch2, i, j - 1), Math.min(dp(ch1, ch2, i - 1, j), dp(ch1, ch2, i - 1, j - 1)))+ 1;
        }
    }

    /**
     * 动态规划（自底向上）
     * dp[i][j]表示将word1[0~i-1]和word2[0~j-1]的最小编辑距离
     */
    public int minDistance2(String word1, String word2) {
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        int M = word1.length(), N = word2.length();
        int[][] dp = new int[M + 1][N + 1];
        // 初始化
        for (int i = 1; i <= M; i++) {
            dp[i][0] = i; // 将多余的i位字符串删除
        }
        for (int j = 1; j <= N; j++) {
            dp[0][j] = j; // 将缺失的j位字符串插入
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i  - 1][j - 1])) + 1;
                }
            }
        }
        return dp[M][N];
    }
}
