package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-11-30
 * @apiNote 剑指 Offer 18. 删除链表的节点
 */
public class Offer18 {

    // Definition for singly-linked list.
    private class ListNode {
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
