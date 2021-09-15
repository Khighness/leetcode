package top.parak.Leetcode;

import java.util.Stack;

/**
 * @author KHighness
 * @since 2020-11-27
 * @apiNote 42. 接雨水
 */
public class T42 {
    /**
     * 单调栈
     * 因为后面的高度小于前面的高度，无法接雨水，因此使用单调递减栈。
     * 找到一根比前面高的柱子立马计算。
     */
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                // 最低高度
                int curr = stack.pop();
                if (stack.isEmpty()) break;
                // 左边界
                int left = stack.peek();
                // 高度差
                int deltaHeight = Math.min(height[i], height[left]) - height[curr];
                ans += (i - 1 - left) * deltaHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 动态数组
     */
    public int trap2(int[] height) {
        int ans = 0, size = height.length;
        if (size < 2) return 0;
        int[] maxLeft = new int[size];
        int[] maxRight = new int[size];
        maxLeft[0] = height[0];
        maxRight[size - 1] = height[size - 1];
        for (int i = 1; i < size; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
        }
        for (int i = size - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return ans;
    }

    /**
     * 双指针
     */
    public int trap3(int[] height) {
        if (height.length <= 2) return 0;
        int ans = 0, maxLeft = 0, maxRight = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < maxLeft) {
                    ans += maxLeft - height[left];
                } else {
                    maxLeft = height[left];
                }
                left++;
            } else {
                if (height[right] < maxRight) {
                    ans += maxRight - height[right];
                } else {
                    maxRight = height[right];
                }
                right++;
            }
        }
        return ans;
    }
}
