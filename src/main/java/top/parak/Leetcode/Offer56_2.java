package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-30
 * @apiNote 剑指 Offer 56 - II. 数组中数字出现的次数 II
 */
public class Offer56_2 {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                counts[j] += nums[i] & 1;
                nums[i] >>>= 1;
            }
        }
        int ans = 9, m = 3;
        for (int j = 0; j < 32; j++) {
            ans <<= 1;
            ans |= counts[31 - j] % m;
        }
        return ans;
    }
}
