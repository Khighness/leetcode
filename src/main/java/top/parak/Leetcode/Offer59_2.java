package top.parak.Leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KHighness
 * @since 2021-08-01
 * @apiNote 剑指 Offer 59 - II. 队列的最大值
 */
public class Offer59_2 {
    static class MaxQueue {
        /** 存储所有的元素 */
        private Queue<Integer> A = new LinkedList<>();
        /** 存储非严格递增 */
        private Deque<Integer> B = new LinkedList<>();

        public MaxQueue() {}

        public int max_value() {
            return B.isEmpty() ? -1 : B.peekFirst();
        }

        public void push_back(int value) {
            A.add(value);
            while (!B.isEmpty() && B.peekLast() < value) {
                B.pollLast();
            }
            B.addLast(value);
        }

        public int pop_front() {
            if (A.isEmpty()) {
                return -1;
            } else {
                Integer x = A.poll();
                if (!B.isEmpty() && B.peekFirst().equals(x)) {
                    B.pollFirst();
                }
                return x;
            }
        }
    }
}
