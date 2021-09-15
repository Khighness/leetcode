package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-27
 * @apiNote 740. 删除并获得点数
 */
public class T740 {

    /**
     * 打家劫舍的变形
     * count[]数组，下标为nums元素，值为nums[i]
     * dp[i] = max(dp[i-1], dp[i-2] + i * count[i])
     */
    public int deleteAndEarn(int[] nums) {
        if (nums == null) return 0;
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int max = nums[0];
        for (int item : nums) max = Math.max(max, item);
        int[] count = new int[max + 1];
        int[] dp = new int[max + 1];
        for (int item : nums) count[item]++;
        dp[1] = count[1];
        dp[2] = Math.max(count[1], 2 * count[2]);
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * count[i]);
        }
        return dp[max];
    }

}
