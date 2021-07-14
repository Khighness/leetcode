package top.parak.Leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author KHighness
 * @since 2020/12/19
 * @apiNote 217. 存在重复元素
 */

public class T217 {
    public boolean solution1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public boolean solution2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}
