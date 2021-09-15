package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-28
 * @apiNote 剑指 Offer 24. 反转链表
 */
public class Offer24 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        // 虚头结点
        ListNode reverseHead = new ListNode(0);
        ListNode temp = head; // 当前结点
        ListNode next = null; // 下一结点
        while (temp != null) {
            next = temp.next; // 保存下一个结点
            // 插入结点
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;      // Temp后移
        }
        return reverseHead.next;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
