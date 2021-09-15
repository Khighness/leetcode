package top.parak.Leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-05-26
 * @apiNote 503. 下一个更大元素 II
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
