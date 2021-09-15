package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-27
 * @apiNote 718. 最长重复子数组
 */
public class T718 {

    /**
     * dp[i][j]表示nums1以i结尾、nums2以j结尾的公共最长
     */
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
