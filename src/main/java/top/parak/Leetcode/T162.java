package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-28
 * @apiNote 162. 寻找峰值
 */

/**
 * Problem:
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
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
            if (nums[i-2] < nums[i-1] && i < nums.length && nums[i-1] > nums[i])
                return i-1;
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
