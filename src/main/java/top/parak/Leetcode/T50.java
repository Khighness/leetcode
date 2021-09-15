package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-09
 * @apiNote 50. Pow(x, n)
 */
public class T50 {
    public double myPow(double x, int n) {
        if (x == 0.0f) {
            return 0.0d;
        }
        long a = n;
        double res = 1.0;
        if (a < 0) {
             x = 1 / x;
             a = -a;
        }
        while (a > 0) {
            if ((a & 1) == 1)
                res *= x;
            x *= x;
            a >>= 1;
        }
        return res;
    }
}
