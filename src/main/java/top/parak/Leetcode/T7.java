package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-01
 * @apiNote 7. 整数反转
 */
public class T7 {

    /**
     * 需要考虑栈溢出
     */
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int cur = x % 10;
            // int: -2147483648 ~ 2147483647
            if ((ans > 214748364 || (ans == 214748364 && cur > 7))
            || (ans < -214748364 || (ans == -214748364 && cur < -8))) {
                return 0;
            }
            ans = ans * 10 + cur;
            x /= 10;
        }
        return ans;
    }

}
