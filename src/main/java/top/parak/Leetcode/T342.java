package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-31
 * @apiNote 342. 4的幂
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
