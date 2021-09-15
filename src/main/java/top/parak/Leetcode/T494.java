package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-21
 * @apiNote 494. 目标和
 */
public class T494 {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, 0, target, 0);
    }

    // 回溯
    private int dfs(int[] nums, int index, int curr, int target, int ans) {
        if (index == nums.length) {
            if (curr == target)
                ans++;
            return ans;
        }
        return dfs(nums, index + 1, curr - nums[index], target, ans) + dfs(nums, index + 1, curr + nums[index], target, ans);
    }

    /**
     * 动态规划
     * dp[i][j]表示数组前i个元素组成和为j的方案数量
     * dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
     */
    public int findTargetSumWays2(int[] nums, int target) {
        int len = nums.length, sum = 0;
        for (int num : nums) sum += num;
        if (Math.abs(target) > Math.abs(sum))
            return 0;
        int ran = 2 * sum + 1;
        int[][] dp = new int[len][ran];
        if (nums[0] == 0) { // 坑
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < ran; j++) {
                int l = Math.max((j - nums[i]), 0);
                int r = (j + nums[i]) < ran ? j + nums[i] : 0;
                dp[i][j] = dp[i - 1][l] + dp[i - 1][r];
            }
        }
        return dp[len - 1][sum + target];
    }

    /**
     * 动态规划，设+子集为x，-子集为y
     * (1) x + y == sum
     * (2) x - y = target
     * 联立x = (sum + target) / 2
     * 从而变成寻找x子集问题
     * 即01背包，选择元素组成x
     */
    public int findTargetSumWays3(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0)
            return 0;
        int x = (sum + target) / 2;
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = x; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[x];
    }
}
