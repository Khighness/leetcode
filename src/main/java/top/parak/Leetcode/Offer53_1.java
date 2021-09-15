package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-09-15
 * @apiNote 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class Offer53_1 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        // 搜索右边界
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int right = l;
        if (r >= 0 && nums[r] != target) {
            return 0;
        }
        l = 0; r = nums.length - 1;
        // 搜索左边界
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        int left = r;
        // System.out.printf("left = %d, right = %d", left, right);
        return right - left - 1;
    }
}
