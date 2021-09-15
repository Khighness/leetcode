package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-22
 * @apiNote 1470. 重新排列数组
 */
public class T1470 {

    public int[] shuffle(int[] nums, int n) {
        // 重新排列后
        // X: index -> 2 * index
        // Y: index -> 2 * (index - n) + 1
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i < n) {
                newNums[2 * i] = nums[i];
            } else {
                newNums[2 *  (i - n) + 1] = nums[i];
            }
        }
        return newNums;
    }

}
