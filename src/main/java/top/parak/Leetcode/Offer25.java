package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/30
 * @apiNote 剑指 Offer 25. 合并两个排序的链表
 */

import java.util.List;

/**
 * Problem:
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class Offer25 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1 == null && l2 == null) return null;
        ListNode head = new ListNode(0), temp = head;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    temp.next = l2;
                    l2 = l2.next;
                } else {
                    temp.next = l1;
                    l1 = l1.next;
                }
            } else {
                if (l1 != null) {
                    temp.next = l1;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    temp.next = l2;
                    l2 = l2.next;
                }
            }
            temp = temp.next;
        }
        return head.next;
    }
}
