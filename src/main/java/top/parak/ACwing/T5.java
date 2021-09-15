package top.parak.ACwing;

import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-09-14
 * @apiNote 5. 多重背包问题 II
 */
public class T5 {
    /**
     * 二进制优化
     * 第i物品最多选s个，可以表示为i个物品选1、2、4个，将问题转换为01背包问题
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), V = sc.nextInt();
        int[] v = new int[N * 12];
        int[] w = new int[N * 12];
        int index = 0;
        for (int i = 1; i <= N; i++) {
            int a = sc.nextInt(),
                    b = sc.nextInt(),
                    s = sc.nextInt();
            for (int k = 1; k <= s; s-= k, k <<= 1) {
                index++;
                v[index] = a * k;
                w[index] = b * k;
            }
            if (s > 0) {
                index++;
                v[index] = a * s;
                w[index] = b * s;
            }
        }
        sc.close();
        N = index;
        int ans = solution(N, V, v, w);
        System.out.println(ans);
    }

    /**
     * 完全背包 II
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
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        return dp[V];
    }
}
