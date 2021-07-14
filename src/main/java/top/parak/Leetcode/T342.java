package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-31
 * @apiNote 342. 4的幂
 */

/**
 * Problem:
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 */
public class T342 {
    public boolean isPowerOfFour(int n) {
        if (n == 1) return true;
        if (n == Integer.MIN_VALUE || n == Integer.MAX_VALUE)
            return false;
        int x = 1 << 2;
        for (int i = 0; i < 30; i += 2) {
            if (x == n) return true;
            x = x << 2;
        }
        return false;
    }

}
