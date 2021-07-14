package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/12
 * @apiNote 69. x 的平方根
 */

/**
 * Problem:
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class T69 {
    /**
     * <p>牛顿法</p>
     * @param x
     * @return
     */
    public int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }
}
