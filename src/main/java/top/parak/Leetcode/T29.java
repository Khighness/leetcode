package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/28
 * @apiNote 29. 两数相除
 */

import java.math.BigDecimal;

/**
 * Problem:
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 */
public class T29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int ans = 0;
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        while (dividend <= divisor) {
            int temp = divisor;
            int curr = 1;
            while (dividend - temp <= temp) {
                temp = temp << 1;
                curr = curr << 1;
            }
            dividend -= temp;
            ans += curr;
        }
        return flag ? ans : -ans;
    }
}
