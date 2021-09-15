package top.parak.Leetcode;

import java.util.Arrays;

/**
 * @author KHighness
 * @since 2021-05-25
 * @apiNote 673. 最长递增子序列的个数
 */
public class T673 {

    /**
     * dp[i]表示以nums[i]结尾的最长递增子序列
     * count[i]表示以nums[i]结尾的最长递增子序列的组合数量
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int[] dp = new int[len];
        int[] count = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 1, ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                    max = Math.max(max, dp[i]);
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (dp[i] == max) {
                ans += count[i];
            }
        }
        return ans;
    }

}
