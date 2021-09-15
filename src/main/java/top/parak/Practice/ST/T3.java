package top.parak.Practice.ST;

/**
 * @author KHighness
 * @since 2021-08-11
 */
public class T3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 在给定药材数量的数组中求不违反规定可以采集到的最大数量
     * @param nums int整型一维数组 每个区域的药材数（首尾区域是相邻的)
     * @return int整型
     */
    public int pick (int[] nums) {
        // write code here
        // 环形打家劫舍
        int n = nums.length;

        return process(nums, 0, n);
    }

    private int process(int[] arr, int l, int r) {
        if (r - l < 1) return 0;
        int[] dp = new int[r + 1];
        dp[l] = arr[l];
        dp[l + 1] = Math.max(arr[l], arr[l + 1]);
        for (int i = l + 1; i <= r; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i - 1], dp[i - 1]);
        }
        return dp[r];
    }
}
