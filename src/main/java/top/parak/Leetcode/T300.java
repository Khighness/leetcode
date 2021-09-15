package top.parak.Leetcode;

import java.util.Arrays;

/**
 * @author KHighness
 * @since 2021-03-28
 * @apiNote 300. 最长递增子序列
 */
public class T300 {

    /**
     * dp[i]表示以i结尾的最长递增子序列长度
     * dp[i] = max(dp[j]) + 1 (nums[j] < nums[i])
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
