package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-28
 * @apiNote 300. 最长递增子序列
 */

/**
 * Problem:
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 */
public class T300 {

    /**
     * dp[i]表示以i结尾的最长递增子序列长度
     * dp[i] = max(dp[j]) + 1 (nums[j] < nums[i])
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 1) return 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
