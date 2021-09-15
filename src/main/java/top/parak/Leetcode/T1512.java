package top.parak.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KHighness
 * @since 2020-09-22
 * @apiNote 1512. 好数对的数目
 */
public class T1512 {

    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> resMap = new HashMap<Integer, Integer>();
        // 数组(下标，数值)存进HashMap
        for (int i = 0; i < nums.length; i++) {
            intMap.put(i, nums[i]);
        }
        // 计算IntMap中相同Value的个数
        for (Map.Entry<Integer, Integer> entry : intMap.entrySet()) {
            if (resMap.containsKey(entry.getValue())) {
                resMap.put(entry.getValue(), resMap.get(entry.getValue()) + 1);
            } else {
                resMap.put(entry.getValue(), 1);
            }
        }
        // 计算C(2, n) = n! / [2! * (n-2)!] = n * (n - 1) / 2
        int ans = 0;
        for (int i : resMap.values()) {
            ans += i * (i - 1) / 2;
        }
        return ans;
    }

}
