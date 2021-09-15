package top.parak.Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KHighness
 * @since 2020-10-01
 * @apiNote 349. 两个数组的交集
 */
public class T349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int value : nums1) {
            set1.add(value);
        }
        for (int value : nums2) {
            if (set1.contains(value)) {
                set2.add(value);
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
