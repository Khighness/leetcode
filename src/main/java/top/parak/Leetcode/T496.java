package top.parak.Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author KHighness
 * @since 2020-11-10
 * @apiNote 496. 下一个更大元素 I
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
