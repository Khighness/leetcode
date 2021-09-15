package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-22
 * @apiNote 1480. 一维数组的动态和
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
