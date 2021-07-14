package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/1 16:13
 * @apiNote 面试题 03.04. 化栈为队
 */

import java.util.Stack;

/**
 * Problem:
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 */
public class Face0304 {
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return stack1.pop();
        }

        /** Get the front element. */
        public int peek() {
            return stack1.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.empty();
        }
    }
}
