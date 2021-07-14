package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/19 16:50
 * @apiNote 1. 两数之和
 */

import java.util.Arrays;
import java.util.HashMap;

/**
 * Problem:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
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

    public static void main(String[] args) {
        Arrays.stream(new T1().twoSum(new int[]{2, 7, 11, 15}, 17)).forEach(System.out::println);
    }

}
