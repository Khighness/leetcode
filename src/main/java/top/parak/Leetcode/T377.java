package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-17
 * @apiNote 377. 组合总和 Ⅳ
 */
public class T377 {

    /**
     * 完全背包，排列，外层遍历背包，内层遍历物品
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] = dp[i] + dp[i - num];
                }
            }
        }
        return dp[target];
    }

}
