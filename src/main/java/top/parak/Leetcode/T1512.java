package top.parak.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KHighness
 * @date 2020/9/22 9:04
 * @apiNote 1512. 好数对的数目
 */

/**
 * Problem:
 * 给你一个整数数组 nums 。
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * 返回好数对的数目。
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

    public static void main(String[] args) {
        System.out.println(new T1512().numIdenticalPairs(
                new int[]{6,5,1,5,7,7,9,1,5,7,1,6,10,9,7,4,1,8,7,1,1,8,6,4,7,4,10,5,3,9,10,1,9,5,5,4,1,7,4,2,9,2,6,6,4,2,10,3,5,3,6,4,7,4,6,4,4,6,3,4,10,1,10,6,10,4,9,6,6,4,8,6,9,5,4}));
    }

}
