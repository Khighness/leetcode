package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/30
 * @apiNote 剑指 Offer 18. 删除链表的节点
 */

/**
 * Problem:
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 */
public class Offer18 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        // 如果删除的是头结点
        if (head.val == val) {
            head = head.next;
            return head;
        }
        // 寻找待删节点的前置结点
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        throw new IllegalArgumentException("NULL");
    }
}
