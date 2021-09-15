package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-27
 * @apiNote 19. 删除链表的倒数第 N 个结点
 */
public class T19 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead, curr = dummyHead;
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
        while (curr.next != null) {
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = prev.next.next;
        return dummyHead.next;
    }
}
