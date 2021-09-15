package top.parak.Leetcode;

import java.math.BigDecimal;

/**
 * @author KHighness
 * @since 2021-03-28
 * @apiNote 剑指 Offer 10- I. 斐波那契数列
 */
public class Offer10 {

    public int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public int fib2(int n) {
        long fib = (long) (Math.sqrt(5) / 5 * (Math.pow((1 + Math.sqrt(5)) / 2, n) - Math.pow((1 - Math.sqrt(5)) / 2, n)));
        System.out.println(fib);
        BigDecimal big = new BigDecimal(fib);
        BigDecimal var = new BigDecimal("1000000007");
        BigDecimal res = big.divideAndRemainder(var)[1];
        return res.intValue();
    }

}
