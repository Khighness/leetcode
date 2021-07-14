package top.parak.Practice.Vivo;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-06-17
 */

public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        String[] W_STR = sc.next().split(",");
        String[] V_STR = sc.next().split(",");
        int N = W_STR.length;
        int[] W = new int[N + 1], V = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            W[i] = Integer.parseInt(W_STR[i - 1]);
            V[i] = Integer.parseInt(V_STR[i - 1]);
        }
        int ans = solution2(C, N, W, V);
        System.out.println(ans);
    }

    /**
     * 动态规划 dp[i][j]表示载重量为j时从0-i种选任意集装箱的最大价值
     */
    private static int solution1(int C, int N, int[] W, int[] V) {
        int[][] dp = new int[N + 1][C + 1];
        for (int i = 0; i <= N; i++)
            dp[i][0] = 0;
        for (int j = 0; j <= C; j++)
            dp[0][j] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                if (j >= W[i]) { // 不选OR选
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - W[i]] + V[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][C];
    }

    /**
     * 动态规划 dp[i]表示载重量为j时的最大价值
     */
    private static int solution2(int C, int N, int[] W, int[] V) {
        int[] dp = new int[C + 1];
        for (int i = 0; i <= C; i++)
            dp[i] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = C; j >= W[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
            }
        }
        return dp[C];
    }

}
