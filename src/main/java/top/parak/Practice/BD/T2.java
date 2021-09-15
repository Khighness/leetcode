package top.parak.Practice.BD;

/**
 * @author KHighness
 * @since 2021-08-09
 */
public class T2 {
    public static void main(String[] args) {
        int n = 2;
        double v = solution1(n);
        System.out.println(String.format("%f7", v));
    }

    public static double solution1(int x) {
        double X0 = x, C = x;
        while (true) {
            double Xi = (X0 + C / X0) * 0.5;
            if (Math.abs(Xi - X0) < 1e-7) {
                break;
            }
            X0 = Xi;
        }
        return X0;
    }

    public static double solution2(int x) {
        double l = 1, r = x;
        while (l < r) {
            double m = (r + l) / 2;
            if (Math.abs(m * m - x) < 1e-7) {
                return m;
            } else if (m * m - x > 0) {
                r = m;
            } else {
                l = m;
            }
        }
        return 0;
    }
}
