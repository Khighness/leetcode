package top.parak.Leetcode;

import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-07-30
 * @apiNote 剑指 Offer 30. 包含min函数的栈
 */

public class Offer30 {

    static class MinStack {
        /** 存储所有的元素 */
        private Stack<Integer> A;
        /** 存储非严格降序 */
        private Stack<Integer> B;

        /** initialize your data structure here. */
        public MinStack() {
            A = new Stack<>();
            B = new Stack<>();
        }

        public void push(int x) {
            A.push(x);
            if (B.isEmpty() || B.peek() >= x) {
                B.push(x);
            }
        }

        public void pop() {
            if (A.pop().equals(B.peek())) {
                B.pop();
            }
        }

        public int top() {
            return A.peek();
        }

        public int min() {
            return B.peek();
        }
    }
}
