package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-30
 * @apiNote 357. 计算各个位数不同的数字个数
 */
public class T357 {

    /**
     * 排列组合
     * n = 0, ans = 1
     * n = 1, ans = 10
     * n = 2, ans = 10 + 9 * 9
     * n = 3, ans = 10 + 9 * 9 + 9 * 9 * 8
     * n = 4, ans = 10 + 9 * 9 + 9 * 9 * 8 + 9 * 9 * 8 * 7
     * ...
     * ans = 10 + 9 * E(9! / (10 - i)!) (2 <= i <= 10)
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        n = Math.min(n , 10);
        int sum = 9, ans = 10, nine = 9;
        for (int i = 1; i < n; i++) {
            sum *= nine--;
            ans += sum;
        }
        return ans;
    }

}
