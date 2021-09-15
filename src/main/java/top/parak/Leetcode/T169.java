package top.parak.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author KHighness
 * @since 2020-11-25
 * @apiNote 169. 多数元素
 */
public class T169 {

    /**
     * 哈希计数
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
     * 排序
     */
    public int solution2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法
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
