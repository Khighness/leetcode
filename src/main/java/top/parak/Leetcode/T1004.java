package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-18
 * @apiNote 1004. 最大连续1的个数 III
 */
public class T1004 {
    /**
     * 滑动窗口
     * 统计窗口内0的个数count
     * 当count > k时，缩小窗口
     * 当count <= k时，更新结果
     */
    public int longestOnes(int[] nums, int k) {
        int ans = 0, len = nums.length;
        int left = 0, right, count = 0;
        for (right = 0; right < len; right++) {
            if (nums[right] == 0)
                count++;
            while (count > k) {
                if (nums[left++] == 0)
                    count--;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
