package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-29
 * @apiNote 剑指 Offer 14- I. 剪绳子
 */

/**
 * Problem:
 *给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Offer14 {

    /**
     * 数学推导
     * 根据算术平方根公式，将n分成a段相等的x时乘积最大
     * n = a * x => a = n / x，此时乘积为 x^(1/x)
     * 那么我们只需要求出函数 y = x^(1/x) 最大值即可
     * 等式两边取对数 lny = (1/x) * lnx
     * 求导      (1/y)y' = -(1/x^2) * lnx + 1/x^2
     * =>       (1/y)y' = (1 - lnx) / x^2
     * =>            y' = (1 - lnx) / x^2 * x^(1/x)
     * 令 y' = 0，则 x = e (~2.7)
     * 函数单调性：y在[1, e)上递增，(e, +♾)上递减
     * MAX(y) = Math.max(y(2), y(3)) = y(3)
     * 因此，尽量将绳子分成多长度为3的片段
     *
     * 算法流程
     * 将n分解=> n = 3 * a + b
     * (1) n <= 3时， ans = n - 1
     *（2）n > 3时
     *      （2.1）b = 0时，ans = 3^a
     *      （2.2）b = 1时，由于1 * 3 < 2 * 2，将3和1分成2和2，ans = 3^(a - 1) * 4
     *      （2.3）b = 2时，ans = 3^a * 2
     */
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        int ans = 0;
        if (b == 0)
            ans = (int) Math.pow(3, a);
        else if (b == 1)
            ans = (int) Math.pow(3, a-1) * 4;
        else
            ans = (int) Math.pow(3, a) * 2;
        return ans;
    }

    /**
     * 动态规划
     * dp[i]表示长度为i的绳子剪成m段后的最大乘积
     * 对于长度为i的绳子，剪掉一段长度为j，剩下的可剪掉可以不剪
     * 剪掉：j * dp[i - j]
     * 不剪：j * (i - j)
     * 状态转移方程：dp[i] = Math.max(dp[i], Math.max(j * dp[i - j]), j * (i - j))
     */
    public int cuttingRope2(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            // 从1开始剪，乘积乘1无意义，所以从2开始
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }

}
