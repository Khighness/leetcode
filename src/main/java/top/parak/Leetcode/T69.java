package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-11-12
 * @apiNote 69. x 的平方根
 */
public class T69 {
    /**
     * 牛顿法迭代
     * X[i+1] = (X[i] + a/X[i]) / 2
     */
    public int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }

    public int mySqrt2(int x) {
        if (x == 0) return 0;
        double C = x, X0 = x;
        while (true) {
            double Xi = 0.5 * (X0 + C / X0);
            if (Math.abs(X0 - Xi) < 1e-7) {
                break;
            }
            X0 = Xi;
        }
        return (int) X0;
    }

    public int mySqrt3(int x) {
        double l = 1, r = x;
        while (l < r) {
            double m = (r + l) / 2;
            if (Math.abs(m * m - x) < 1e-7) {
                return (int) m;
            } else if (m * m - x > 0) {
                r = m;
            } else {
                l = m;
            }
        }
        return 0;
    }
}
