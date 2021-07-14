package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/1 15:00
 * @apiNote 561. 数组拆分 I
 */

import java.util.Arrays;

/**
 * Probem:
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 */
public class T561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0 ; i < nums.length - 1; i += 2) {
            ans += Math.min(nums[i], nums[i + 1]);
        }
        return ans;
    }

}
