package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-11-30
 * @apiNote 剑指 Offer 52. 两个链表的第一个公共节点
 */
public class Offer52 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 获取链表长度
     */
    public int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = length(headA), lengthB = length(headB);
        ListNode longNode = headA, shortNode = headB;
        if (lengthA < lengthB) {
            longNode = headB;
            shortNode = headA;
        }
        int length = Math.abs(lengthA - lengthB);
        while (length-- != 0) {
            longNode = longNode.next;
        }
        while (longNode != null && shortNode != null && longNode != shortNode) {
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return longNode;
    }

}
