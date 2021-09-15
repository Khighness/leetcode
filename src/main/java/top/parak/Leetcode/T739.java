package top.parak.Leetcode;

import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-05-26
 * @apiNote 739. 每日温度
 */
public class T739 {

    /**
     * 单调栈
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int curr = stack.pop();
                res[curr] = i - curr;
            }
            stack.push(i);
        }
        return res;
    }

}
