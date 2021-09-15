package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-30
 * @apiNote 剑指 Offer 16. 数值的整数次方
 */
public class Offer16 {
    /**
     * n十进制转二进制
     */
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double ans = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1)
                ans *= x;
            x *= x;
            b = b >> 1;
        }
        return ans;
    }
}
