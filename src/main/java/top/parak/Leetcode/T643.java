package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-11-15
 * @apiNote 643. 子数组最大平均数 I
 */
public class T643 {

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        System.out.println(sum);
        double max = sum;
        for (int i = k; i < nums.length; i++) {
                sum += nums[i] - nums[i - k];
                max = Math.max(max, sum);
        }
        return max / k;
    }

}
