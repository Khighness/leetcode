package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-18
 * @apiNote 1477. 找两个和为目标值且不重叠的子数组
 */
public class T1477 {

    /**
     * 动态规划
     * dp[i]表示子数组[0,i)中满足条件的子数组的最短长度
     * 通过双指针，求出所有[left, right]子数组的值
     * 每找到一个满足条件的子数组，那么两个数组长度为dp[left]和right - left + 1
     */
    public int minSumOfLengths(int[] arr, int target) {
        int len = arr.length, sum = 0;
        int ans = Integer.MAX_VALUE, left = 0, right = 0;
        int[] dp = new int[len + 1];
        dp[0] = len + 1;
        for (right = 0; right < len; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int sub = right - left + 1;
                ans = Math.min(ans, sub + dp[left]);
                dp[right + 1] = Math.min(dp[right], sub);
            } else {
                dp[right + 1] = dp[right];
            }
        }
        return ans > len ? -1 : ans;
    }

}
