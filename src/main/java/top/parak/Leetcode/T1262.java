package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-28
 * @apiNote 1262. 可被三整除的最大和
 */
public class T1262 {

    /**
     * dp[0],dp[1],dp[2]分别为余数0,1,2时的最大值
     */
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[] dp = new int[3];
        int[] tm = new int[3];
        for (int num : nums) {
            for (int k = 0; k < 3; k++)
                tm[k] = dp[k] + num;
            for (int k = 0; k < 3; k++)
                dp[tm[k] % 3] = Math.max(dp[tm[k] % 3], tm[k]);
        }
        return dp[0];
    }

}
