package top.parak.Leetcode;

/**
 * <p> Project: Algorithm </P>
 * <p> Package: top.parak.Leetcode </p>
 * <p> FileName: T238 <p>
 * <p> Description: 238. 除自身以外数组的乘积 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/9
 */

/**
 * Problem:
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 */
public class T238 {
    public int[] productExceptSelf(int[] nums) {
        // 记录0的数量
        int countZero = 0;
        // 记录所有不为零的数的乘积
        int multiRes = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZero++;
            } else {
                multiRes *= nums[i];
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
            for (int i = 0; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
        return nums;
    }
}
