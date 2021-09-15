package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-08
 * @apiNote 1137. 第 N 个泰波那契数
 */
public class T1137 {

    public int tribonacci(int n) {
        int T0 = 0, T1 = 1, T2 = 1;
        if (n == 0) return T0;
        if (n == 1) return T1;
        if (n == 2) return T2;
        int Tn = 0;
        for (int i = 3; i <= n; i++) {
            Tn = T0 + T1 + T2;
            T0 = T1;
            T1 = T2;
            T2 = Tn;
        }
        return Tn;
    }

}
