package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-12-01
 * @apiNote 160. 相交链表
 */
public class T160 {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode longHead = headA, shortHead = headB;
        int lengthA = lengthOf(headA), lengthB = lengthOf(headB);
        if (lengthA < lengthB) {
            longHead = headB;
            shortHead = headA;
        }
        int length = Math.abs(lengthA - lengthB);
        while (length-- != 0) {
            longHead = longHead.next;
        }
        while (longHead != null && shortHead != null) {
            if (longHead == shortHead) {
                return longHead;
            }
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return null;
    }

    public int lengthOf(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
