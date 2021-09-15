package top.parak.Leetcode;

import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-05-13
 * @apiNote 84. 柱状图中最大的矩形
 */
public class T84 {
    /**
     * 单调递增栈
     * 对于每一个高度，确定向左和向右的边界，即可求出高度的最大面积
     */
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        // 前后补0，防止递增一直无法弹栈
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        for (int i = 0; i < newHeights.length; i++) {
            // 当前高度小于栈顶高度，即为右边界
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                // 当前高度下标
                int curr = stack.pop();
                // 左边界
                int left = stack.peek();
                ans = Math.max(ans, (i - left - 1) * newHeights[curr]);
            }
            stack.push(i);
        }
        return ans;
    }
}
