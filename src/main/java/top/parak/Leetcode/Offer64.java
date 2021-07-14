package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/12/4
 * @apiNote 剑指 Offer 64. 求1+2+…+n
 */

/**
 * Problem:
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Offer64 {
    /**
     * <p>递归</p>
     * @param n
     * @return
     */
    public int sumNums(int n) {
        if (n == 0) {
            return n;
        }
        return n + sumNums(n - 1);
    }
}
