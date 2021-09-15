package top.parak.Leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author KHighness
 * @since 2021-08-01
 * @apiNote 剑指 Offer 59 - I. 滑动窗口的最大值
 */
public class Offer59_1 {
    /**
     * 单调队列，一共n - k + 1个窗口
     * 保证队列非单调递减，队尾插入，队头取max
     *
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        // 第1个窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 第2~i-k+1个窗口
        for (int i = k; i < n; i++) {
            // 上一个窗口队头出队
            if (!deque.isEmpty() && deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            // 保证队列非严格递减
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
