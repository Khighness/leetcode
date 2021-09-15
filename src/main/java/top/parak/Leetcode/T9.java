package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-01
 * @apiNote 9. 回文数
 */
public class T9 {
    /**
     * 取后半段数字进行翻转
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int y = 0;
        while (x > y) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return x == y || x == y / 10;
    }
}
