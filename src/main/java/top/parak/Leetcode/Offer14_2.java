package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-09
 */
public class Offer14_2 {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1)
                rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if (b == 0) return (int) (rem * 3 % p);
        if (b == 1) return (int) (rem * 4 % p);
        return (int) (rem * 6 % p);
    }

    public int cuttingRope2(int n) {
        if (n <= 3) return n - 1;
        long res = 1L;
        int p = (int) 1e9 + 7;
        // 贪心：优先切3，其次切2
        while (n > 4) {
            res = res * 3 % p;
            n -= 3;
        }
        // 最后n只可能为2、3、4
        return (int) (res * n % p);
    }
}
