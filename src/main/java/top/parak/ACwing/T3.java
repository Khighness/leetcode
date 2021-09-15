package top.parak.ACwing;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-09-14
 * @apiNote 3. 完全背包问题
 */
public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), V = sc.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        sc.close();
        int ans = solution(N, V, v, w);
        System.out.println(ans);
    }

    /**
     * 完全背包
     *
     * @param N 物品数量
     * @param V 最大容量
     * @param v 物品体积
     * @param w 物品价值
     * @return 最大价值
     */
    private static int solution(int N, int V, int[] v, int[] w) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= 1; j--) {
                for (int k = 0; k <= j / v[i]; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
        }
        return dp[V];
    }
}
