package top.parak.Leetcode;

import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-08-21
 * @apiNote 155. 最小栈
 */
public class T155 {
    class MinStack {
        // 存储所有
        private Stack<Integer> A;
        // 存储min
        private Stack<Integer> B;

        /** initialize your data structure here. */
        public MinStack() {
            A = new Stack<>();
            B = new Stack<>();
        }

        public void push(int val) {
            A.push(val);
            if (B.isEmpty() || B.peek() >= val) {
                B.push(val);
            }
        }

        public void pop() {
            Integer top = A.pop();
            if (top.equals(B.peek())) {
                B.pop();
            }
        }

        public int top() {
            return A.peek();
        }

        public int getMin() {
            return B.peek();
        }
    }
}
