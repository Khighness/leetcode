package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-05
 * @apiNote Offer62. 圆圈中最后剩下的数字
 */

/**
 * Problem:
 * 0 ~ n-1 这n和数字排成一个圆圈，从数字0开始，每次从这n个圆圈里删除m个数字，求出这个圆圈里剩下的最后一个数字
 */
public class Offer62 {
    /**
     * n = 1, f(n, m) = 1
     * n > 1, f(n, m) = [f(n - 1, m) + m] % n
     */
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
