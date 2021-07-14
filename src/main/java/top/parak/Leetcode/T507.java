package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/17
 * @apiNote 507. 完美数
 */

/**
 * Problem:
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 */
public class T507 {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int factorSum = 1, times = (int) Math.sqrt(num);
        for (int i = 2; i <= times; i++) {
            if (num % i == 0) {
                factorSum += i + num / i;
            }
        }
        return factorSum == num;
    }


}
