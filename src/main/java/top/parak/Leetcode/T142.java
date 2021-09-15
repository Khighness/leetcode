package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-17
 * @apiNote 142. 环形链表 II
 */
public class T142 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slot = head, fast = head.next;
        while (slot != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slot = slot.next;
            fast = fast.next.next;
        }
        fast = head;
        slot = slot.next;
        while (slot != fast) {
            slot = slot.next;
            fast = fast.next;
        }
        return fast;
    }
}
