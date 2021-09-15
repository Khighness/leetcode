package top.parak.Leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author KHighness
 * @since 2020-11-09
 * @apiNote 239. 滑动窗口最大值
 */
public class T239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        /* 结果索引 */
        int maxIndex = 0;
        /* 返回结果 */
        int[] maxArry = new int[nums.length - k + 1];
        if (nums.length >= k && k >= 1) {
            /* 双向队列保存可能为滑动窗口的最大数值的下标
            * 特点：队列头部下标对应数值永远最大 */
            Deque<Integer> index = new LinkedList<>();

            for (int i = 0; i < k; i++) {
                /* 在队列存入下一个数值下标之前，判断队列尾部的下标对应数值是否小于代存数值的下标
                * 若小于，则循环移除尾部下标 */
                while (!index.isEmpty() && nums[i] >= nums[index.getLast()]) {
                    index.removeLast();
                }
                index.addLast(i);
            }

            for (int i = k; i < nums.length; i++) {
                maxArry[maxIndex++] = nums[index.getFirst()];

                while (!index.isEmpty() && nums[i] >= nums[index.getLast()]) {
                    index.removeLast();
                }

                /* 若当前队列头的下标已经滑出滑动窗口，则移除头部 */
                if (!index.isEmpty() && index.getFirst() <= i - k) {
                    index.removeFirst();
                }

                index.addLast(i);
            }
            maxArry[maxIndex++] = nums[index.getFirst()];
        }
        return maxArry;
    }

}
