package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-25
 * @apiNote 1295. 统计位数为偶数的数字
 */
public class T1295 {

    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (getDigits(num) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    public int getDigits(int num) {
        int ans = 0;
        while (num != 0) {
            num /= 10;
            ans++;
        }
        return ans;
    }

}
