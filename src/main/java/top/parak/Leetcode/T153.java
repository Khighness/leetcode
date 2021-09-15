package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-21
 * @apiNote 153. 寻找旋转排序数组中的最小值
 */
public class T153 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] >= nums[0]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[r];
    }
}
