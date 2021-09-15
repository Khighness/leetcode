package top.parak.Algorithm.Dynamic;

/**
 * @author KHighness
 * @since 2021-03-29
 * @apiNote KMP
 */
public class KnuthMorrisPratt {

    private String pat;
    private int[][] dp;

    /**
     * dp[i][j]其中i表示当前状态，j表示当前字符，dp[i][j]表示下一个状态
     */
    public KnuthMorrisPratt(String pat) {
        this.pat = pat;
        int M = pat.length();
        dp = new int[M][256];
        // dp[状态][字符] = 下个状态
        dp[0][pat.charAt(0)] = 1;
        int x = 0; // 影子状态
        // 构建状态转移图
        for (int i = 1; i < M; i++) {
            for (int c = 0; c < 256; c++) {
                if (pat.charAt(i) == c)
                    dp[i][c] = i + 1;
                else
                    dp[i][c] = dp[x][c];
            }
            // 更新影子状态
            x = dp[x][pat.charAt(i)];
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 计算pat的下一个状态
            j = dp[j][txt.charAt(i)];
            if (j == M)
                return i - M + 1;
        }
        return -1;
    }

}
