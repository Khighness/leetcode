package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-17
 * @apiNote 209. 长度最小的子数组
 */

/**
 * Problem:
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class T209 {
    /**
     * 双指针
     */
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, len = nums.length,
                left = 0, right = 0;
        boolean found = false;
        while (right < len) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
            if (sum >= target) {
                found = true;
                ans = Math.min(ans, right - left + 1);
                left++;
            } else {
                right++;
            }
        }
        return found ? ans : 0;
    }

    /**
     * 滑动窗口 => 累加
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, len = nums.length,
                left = 0, right = 0, sum = 0; // left记录窗口的尾部，right记录窗口的头部, sum记录窗口的值
        while (right < len) {
            // 进入窗口
            sum += nums[right++];
            while (sum >= target) {
                ans = Math.min(ans, right - left);
                // 退出窗口
                sum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 优化 => 直接减
     */
    public int minSubArrayLen3(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, len = nums.length,
                left = 0, right = 0; // left记录窗口的尾部，right记录窗口的头部
        while (right < len) {
            target -= nums[right++];
            while (target <= 0) {
                ans = Math.min(ans, right - left);
                target += nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
