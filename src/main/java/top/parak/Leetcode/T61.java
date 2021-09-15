package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-12-01
 * @apiNote 61. 旋转链表
 */
public class T61 {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int length = lengthOf(head);
        if (k % length == 0) {
            return head;
        }
        int offset = length - k % length;
        // 寻找分界结点
        ListNode temp = head;
        offset--;
        while (offset-- != 0) {
            temp = temp.next;
        }
        // 新的尾结点和头节点
        ListNode newTail = temp, newHead = temp.next;
        // 寻找最后一个结点
        while (temp.next != null) {
            temp = temp.next;
        }
        newTail.next = null;
        temp.next = head;
        return newHead;
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
