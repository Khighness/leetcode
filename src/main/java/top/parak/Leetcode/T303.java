package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-25
 * @apiNote 303. 区域和检索 - 数组不可变
 */

/**
 * Problem:
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * 实现 NumArray 类：
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 */
public class T303 {
    static class NumArray {
        private int[] nums;
        private int[] preSum;

        public NumArray(int[] nums) {
            this.nums = nums;
            // 前缀和preSum表示0~i-1的元素和
            preSum = new int[nums.length + 1];
            preSum[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                preSum[i + 1] += preSum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
}
