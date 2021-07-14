package top.parak.Leetcode;

/**
 * <p> Project: Algorithm </P>
 * <p> Package: top.parak.Leetcode </p>
 * <p> FileName: T239 <p>
 * <p> Description: 239. 滑动窗口最大值 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/9
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Problem:
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
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
