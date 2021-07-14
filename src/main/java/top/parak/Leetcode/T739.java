package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-26
 * @apiNote 739. 每日温度
 */

import java.util.Stack;

/**
 * Problem:
 * 请根据每日 气温 列表，重新生成一个列表。
 * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
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
