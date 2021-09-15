package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-29
 * @apiNote 198. 打家劫舍
 */
public class T198 {

    /**
     * dp[i]表示偷[0-i]家的最大金额
     */
    public int rob1(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    /**
     * 第一种简化
     */
    public int rob2(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int dp_0 = nums[0];
        int dp_1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int temp = dp_1;
            dp_1 = Math.max(dp_1, dp_0 + nums[i]);
            dp_0 = temp;
        }
        return dp_1;
    }

    /**
     * dp[i]表示从第i家开始偷能偷到的最大金额
     */
    public int rob3(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[len - 1] = nums[len - 1];
        dp[len - 2] = Math.max(nums[len - 1], nums[len - 2]);
        for (int i = len - 3; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }

    /**
     * 第二种简化
     */
    public int rob4(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int dp_2 = nums[len - 1];
        int dp_1 = Math.max(nums[len - 1], nums[len - 2]);
        for (int i = len - 3; i >= 0; i--) {
            int temp = dp_1;
            dp_1 = Math.max(dp_1, dp_2 + nums[i]);
            dp_2 = temp;
        }
        return dp_2;
    }

}
