package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-26
 * @apiNote 503. 下一个更大元素 II
 */

import java.util.Arrays;
import java.util.Stack;

/**
 * Problem:
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1
 */
public class T503 {
    /**
     * 单调栈
     * 将原循环数组拉直，复制数组的前n-1个元素拼接在数组的后面
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * len - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i);
        }
        return res;
    }
}
