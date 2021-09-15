package top.parak.Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author KHighness
 * @since 2021-08-27
 * @apiNote 295. 数据流的中位数
 */
public class T295 {

    /**
     * 双堆存储，最大堆和最小堆
     * 总数量为奇数时，最大堆数多一
     * 总数量为偶数时，两堆数量相同
     * 每次添加元素，先操作最大堆，再操作最小堆
     */
    class MedianFinder {
        private int count;
        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;

        /** initialize your data structure here. */
        public MedianFinder() {
            count = 0;
            maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
            minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        }

        public void addNum(int num) {
            count++;
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if ((count & 1) != 0) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if ((count & 1) == 0) {
                return (double) (maxHeap.peek() + minHeap.peek()) * 0.5;
            } else {
                return maxHeap.peek();
            }
        }
    }

}
