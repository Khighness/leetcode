package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/30
 * @apiNote 剑指 Offer 06. 从尾到头打印链表
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Problem:
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
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
