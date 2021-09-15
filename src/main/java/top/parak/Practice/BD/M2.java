package top.parak.Practice.BD;

import java.util.Scanner;

/**
 * 对于一个十进制数x，如果x的每一位数字都只可能为1、2、3，那么x就是一个完美数。
 * 第一行输入一个整数T，代表数据组数，然后每一行输入整数n，输出不大于n的完美数。
 * 1 < T < 10^5, 1 < n < 10^15
 *
 * @author KHighness
 * @since 2021-09-07
 */
public class M2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            System.out.println(f(n));
        }
    }

    private static long f(long n) {
        int index = 0;
        long[] dp = new long[Integer.MAX_VALUE];
        dp[index] = 0;
        int a = 0, b = 0, c = 0;
        long dp_a, dp_b, dp_c;
        while (true) {
            dp_a = dp[a] * 10 + 1;
            dp_b = dp[b] * 10 + 2;
            dp_c = dp[c] * 10 + 3;
            dp[++index] = Math.min(dp_a, Math.min(dp_b, dp_c));
            if (dp[index] == dp_a) a++;
            if (dp[index] == dp_b) b++;
            if (dp[index] == dp_c) c++;
            if (dp[index] == n) {
                return dp[index];
            }
            if (dp[index] > n && dp[index - 1] < n) {
                return dp[index - 1];
            }
        }
    }
}
