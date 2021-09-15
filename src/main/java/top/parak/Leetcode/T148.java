package top.parak.Leetcode;

import java.util.List;

/**
 * @author KHighness
 * @since 2021-09-13
 * @apiNote 148. 排序链表
 */
public class T148 {

    // Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = midNode(head);
        ListNode rightNode = midNode.next;
        midNode.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightNode);
        return mergeTwoList(left, right);
    }

    private ListNode midNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l1.next = mergeTwoList(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoList(l1, l2.next);
                return l2;
            }
        }
        return l1 != null ? l1 : l2;
    }
}
