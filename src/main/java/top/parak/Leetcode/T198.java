package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-29
 * @apiNote 198. 打家劫舍
 */

/**
 * Problem:
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
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
     * 第二种方式
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
