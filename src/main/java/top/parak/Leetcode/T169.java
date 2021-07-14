package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/25
 * @apiNote 169. 多数元素
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class T169 {
    /**
     * <p>哈希计数</p>
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("null");
    }

    /**
     * <p>排序</p>
     * @param nums
     * @return
     */
    public int solution2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * <p>摩尔投票法</p>
     * @param nums
     * @return
     */
    public int solution3(int[] nums) {
        int ans = nums[0], times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ans) {
                times++;
            } else {
                times--;
                if (times == 0) {
                    ans = nums[i];
                    times = 1;
                }
            }
        }
        return ans;
    }
}
