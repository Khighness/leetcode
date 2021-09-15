package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-29
 * @apiNote 213. 打家劫舍 II
 */
public class T213 {

    /**
     * 要么偷头，要么偷屁股
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        return Math.max(process(nums, 0, len - 2), process(nums, 1, len - 1));
    }

    public int process(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int dp_0 = nums[start];
        int dp_1 = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = dp_1;
            dp_1 = Math.max(dp_1, dp_0 + nums[i]);
            dp_0 = temp;
        }
        return dp_1;
    }

}
