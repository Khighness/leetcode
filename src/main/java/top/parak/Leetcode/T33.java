package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-21
 * @apiNote 33. 搜索旋转排序数组
 */
public class T33 {
    // 旋转数组的特点：左半段递增，右半段递减
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m = 0;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (nums[m] == target) {
                return m;
            }
            // m在左段
            if (nums[m] >= nums[l]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            // m在右段
            else {
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
