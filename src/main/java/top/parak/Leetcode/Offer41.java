package top.parak.Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author KHighness
 * @since 2021-07-31
 * @apiNote 41. 缺失的第一个正数
 */
public class Offer41 {

    static class MedianFinder {
        /** 小顶堆，存储较大的一半 */
        private PriorityQueue<Integer> A = new PriorityQueue<>(Comparator.comparing(a -> a));
        /** 大顶堆，存储较小的一半 */
        private PriorityQueue<Integer> B = new PriorityQueue<>(Comparator.comparing(a -> -a));

        /** initialize your data structure here. */
        public MedianFinder() { }

        public void addNum(int num) {
            if (A.size() != B.size()) {
                A.add(num);
                B.add(A.poll());
            } else {
                B.add(num);
                A.add(B.poll());
            }
        }

        public double findMedian() {
            if (A.size() == B.size()) {
                return (A.peek() + B.peek()) * 0.5;
            } else {
                return A.peek();
            }
        }
    }
}
