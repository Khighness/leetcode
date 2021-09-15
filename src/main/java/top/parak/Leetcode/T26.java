package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-01
 * @apiNote 26. 删除有序数组中的重复项
 */
public class T26 {
    /**
     * 双指针
     * 慢指针用于填充不同元素，快指针用于跳过相同元素
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int fast = 0, slow = 0;
        while (fast < n) {
            while (fast < n - 1 && nums[fast] == nums[fast + 1]) {
                fast++;
            }
            nums[slow++] = nums[fast];
            fast++;
        }
        return slow;
    }
}
