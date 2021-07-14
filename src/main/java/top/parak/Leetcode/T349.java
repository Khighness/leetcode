package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/1 16:32
 * @apiNote 349. 两个数组的交集
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class T349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        int index = 0;
        int[] ans = new int[set2.size()];
        for (int i : set2) {
            ans[index++] = i;
        }
        return ans;
    }
}
