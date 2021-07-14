package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/22 9:01
 * @apiNote 1480. 一维数组的动态和
 */

/**
 * Problem:
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 */
public class T1480 {

    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            runningSum[i] = sum;
        }
        return runningSum;
    }

}
