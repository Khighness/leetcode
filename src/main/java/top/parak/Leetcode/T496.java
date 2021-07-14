package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/10
 * @apiNote 496. 下一个更大元素 I
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Problem:
 * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 */
public class T496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int curr = stack.pop();
                map.put(nums2[curr], nums2[i]);
            }
            stack.push(i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
