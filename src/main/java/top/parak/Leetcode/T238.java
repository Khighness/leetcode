package top.parak.Leetcode;

import java.util.Arrays;

/**
 * @author KHighness
 * @since 2020-11-09
 * @apiNote 238. 除自身以外数组的乘积
 */
public class T238 {

    public int[] productExceptSelf(int[] nums) {
        // 记录0的数量
        int countZero = 0;
        // 记录所有不为零的数的乘积
        int multiRes = 1;
        for (int num : nums) {
            if (num == 0) {
                countZero++;
            } else {
                multiRes *= num;
            }
        }
        if (countZero == 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = multiRes / nums[i];
            }
        } else if (countZero == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    nums[i] = multiRes;
                } else {
                    nums[i] = 0;
                }
            }
        } else {
            Arrays.fill(nums, 0);
        }
        return nums;
    }

}
