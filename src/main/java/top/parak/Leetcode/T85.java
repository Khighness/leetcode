package top.parak.Leetcode;

import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-05-13
 * @apiNote 85. 最大矩形
 */
public class T85 {
    /**
     * 单调栈
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        int ans = 0;
        int[] height = new int[n + 2];
        for (char[] chars : matrix) {
            for (int j = 0; j < n; j++) {
                if (chars[j] == '1')
                    height[j + 1] += 1;
                else
                    height[j + 1] = 0;
            }
            ans = Math.max(ans, maxArea(height));
        }
        return ans;
    }

    private int maxArea(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int curr = stack.pop();
                int left = stack.peek();
                res = Math.max(res, (i - left - 1) * height[curr]);
            }
            stack.push(i);
        }
        return res;
    }
}
