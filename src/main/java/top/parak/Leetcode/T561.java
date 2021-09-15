package top.parak.Leetcode;

import java.util.Arrays;

/**
 * @author KHighness
 * @since 2020-10-01
 * @apiNote 561. 数组拆分 I
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
