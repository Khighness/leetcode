package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-30
 * @apiNote 剑指 Offer 57. 和为s的两个数字
 */
public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] + nums[r] == target) {
                return new int[] {nums[l], nums[r]};
            } else if (nums[l] + nums[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }
}
