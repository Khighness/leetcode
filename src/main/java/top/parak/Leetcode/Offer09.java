package top.parak.Leetcode;

import java.util.Stack;

/**
 * @author KHighness
 * @since 2020-09-29
 * @apiNote 剑指 Offer 09. 用两个栈实现队列
 */
public class Offer09 {

    class CQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                return -1;
            } else {
                return stack2.pop();
            }
        }
    }

}
