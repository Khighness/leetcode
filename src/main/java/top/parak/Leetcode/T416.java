package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-17
 * @apiNote 416. 分割等和子集
 */
public class T416 {

    /**
     * 数组总和sum，寻找子集等于sum/2
     * 转换成使用nums中的数组合成sum/2
     * 即01背包问题
     * dp[i]表示能否用nums中的数组成i
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }

}
