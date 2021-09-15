package top.parak.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KHighness
 * @since 2020-11-15
 * @apiNote 645. 错误的集合
 */
public class T645 {

    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
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
