package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/14
 * @apiNote 334. 递增的三元子序列
 */

/**
 * Problem:
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 */
public class T334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int min = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) // 当前数 <= 最小数
                min = nums[i];
            else if (nums[i] <= second)  // 最小数 <= 当前数 <= 第二大数
                second = nums[i];
            else return true;  // 第二大数 <= 当前数
        }
        return false;
    }
}
