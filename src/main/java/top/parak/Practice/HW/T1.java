package top.parak.Practice.HW;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-08-18
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt(), N = sc.nextInt();
        int[] P = new int[N], C = new int[N], L = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
            C[i] = sc.nextInt();
            L[i] = sc.nextInt();
        }
        int ans = solution(X, N, P, C, L);
        System.out.println(ans);
    }

    /**
     * 多重背包问题
     *
     * @param X 可使用金额
     * @param N 零食种类
     * @param P 零食价格
     * @param C 零食数量
     * @param L 喜爱度
     * @return 最大喜爱度
     */
    private static int solution(int X, int N, int[] P, int[] C, int[] L) {
        int[] dp = new int[X + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = X; j >= 0; j--) {
                for (int k = 0; k <= C[i - 1] && k * P[i - 1] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j -  k * P[i- 1]] + k * L[i - 1]);
                }
            }
        }
        return dp[X];
    }
}
