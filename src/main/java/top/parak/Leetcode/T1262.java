package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-28
 * @apiNote 1262. 可被三整除的最大和
 */

/**
 * Problem:
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 */
public class T1262 {
    /**
     * dp[0],dp[1],dp[2]分别为余数0,1,2时的最大值
     */
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[] dp = new int[3];
        int[] tm = new int[3];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < 3; k++)
                tm[k] = dp[k] + nums[i];
            for (int k = 0; k < 3; k++)
                dp[tm[k] % 3] = Math.max(dp[tm[k] % 3], tm[k]);
        }
        return dp[0];
    }
}
//            int a = dp[0] + nums[i];
//            int b = dp[1] + nums[i];
//            int c = dp[2] + nums[i];
//            dp[a % 3] = Math.max(dp[a % 3], a);
//            dp[b % 3] = Math.max(dp[b % 3], b);
//            dp[c % 3] = Math.max(dp[c % 3], c);
