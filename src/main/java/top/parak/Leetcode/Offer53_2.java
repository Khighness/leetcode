package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-09-14
 * @apiNote 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class Offer53_2 {
    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] == m) l = m + 1;
            else r = m - 1;
        }
        return l;
    }
}
