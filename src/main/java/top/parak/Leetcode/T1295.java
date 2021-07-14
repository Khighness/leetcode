package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/25 20:22
 * @apiNote 1295. 统计位数为偶数的数字
 */

/**
 * Problem:
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
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
