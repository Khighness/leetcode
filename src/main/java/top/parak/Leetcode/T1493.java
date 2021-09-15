package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-18
 * @apiNote 1493. 删掉一个元素以后全为 1 的最长子数组
 */
public class T1493 {

    /**
     * 遍历每一个0，计算1的左边界和右边界
     */
    public int longestSubarray(int[] nums) {
        int ans = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            int left = 0, right = 0;
            for (left = i - 1; left >= 0 && nums[left] == 1; left--) { }
            for (right = i + 1; right < len && nums[right] == 1; right++) { }
            ans = Math.max(ans, right - left - 2);
        }
        return ans;
    }

    /**
     * 滑动窗口，计算替换一个0成1后的最长长度，结果-1
     */
    public int longestSubarray2(int[] nums) {
        int ans = 0, len = nums.length;
        int left = 0, right, count = 0;
        for (right = 0; right < len; right++) {
            if (nums[right] == 0)
                count++;
            while (count > 1) {
                if (nums[left++] == 0)
                    count--;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans - 1;
    }

}
