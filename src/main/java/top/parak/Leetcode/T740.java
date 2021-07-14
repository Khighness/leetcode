package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-27
 * @apiNote 740. 删除并获得点数
 */

/**
 * Problem:
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
