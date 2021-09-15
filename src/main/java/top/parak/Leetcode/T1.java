package top.parak.Leetcode;

import java.util.HashMap;

/**
 * @author KHighness
 * @since 2020-09-19
 * @apiNote 1. 两数之和
 */
public class T1 {

    public int[] twoSum(int[] nums, int target) {
        // Key存值，value存下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res) && map.get(res) != i) {
                return new int[] {map.get(res), i};
            }
        }
        throw new RuntimeException("NULL");
    }

}
