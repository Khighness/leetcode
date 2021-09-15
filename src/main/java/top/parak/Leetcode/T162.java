package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-28
 * @apiNote 162. 寻找峰值
 */
public class T162 {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int max, maxIndex;
        if (nums[0] > nums[1]) {
            max = nums[0];
            maxIndex = 0;
        } else {
            max = nums[1];
            maxIndex = 1;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 2] < nums[i - 1] && nums[i - 1] > nums[i])
                return i-1;
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
