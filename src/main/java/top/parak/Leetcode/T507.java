package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-11-17
 * @apiNote 507. 完美数
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
