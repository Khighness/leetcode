package top.parak.Leetcode;

import java.util.Stack;

/**
 * @author KHighness
 * @since 2020-11-30
 * @apiNote 剑指 Offer 06. 从尾到头打印链表
 */
public class Offer06 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        int index = 0;
        int[] res = new int[stack.size()];
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }
}
