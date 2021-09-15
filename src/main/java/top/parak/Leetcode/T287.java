package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-17
 * @apiNote 287. 寻找重复数
 */
public class T287 {

    /**
     * 双指针
     */
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
