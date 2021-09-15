package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-25
 * @apiNote 303. 区域和检索 - 数组不可变
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
