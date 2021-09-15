package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-24
 * @apiNote 283. 移动零
 */
public class T283 {

    /**
     * 第一次遍历，一个指针，记录非零元素数量，将非零元素移动到0元素位置
     * 第二次遍历，将上次指针右边元素全部置为零
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) return;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 快排思想
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null) return;
        // 指向0的位置
        int index = 0;
        for (int i = index; i < nums.length; i++) {
            // 指向非零的位置
            // 一旦出现0，交换
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index++] = tmp;
            }
        }
    }

}
