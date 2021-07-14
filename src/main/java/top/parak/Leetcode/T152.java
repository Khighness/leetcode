package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-25
 * @apiNote 152. 乘积最大子数组
 */

/**
 * Problem:
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class T152 {
    /**
     * 动态规划
     * 有坑，由于存在负数，可能导致最大变为最小，最小变为最大
     * max表示从0~i的最大连续乘积，min表示从0~i的最小连续乘积
     * 遍历数组，碰到负数时，将max和min交换
     */
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int ans = Integer.MIN_VALUE, max = 1, min = 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }

}
