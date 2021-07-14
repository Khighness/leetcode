package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/15
 * @apiNote 645. 错误的集合
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 */
public class T645 {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] res = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    res[0] = i;
                }
            } else {
                res[1] = i;
            }
        }
        return res;
    }
}
