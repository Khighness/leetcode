package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-29
 * @apiNote 213. 打家劫舍 II
 */

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
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
