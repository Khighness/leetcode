package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-16
 * @apiNote 25. K 个一组翻转链表
 */
public class T25 {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prevNode = dummyHead, leftNode = head;
        ListNode currNode = head; int len = 0;
        while (currNode != null) {
            currNode = currNode.next;
            len++;
        }
        while (len >= k) {
            len -= k;
            for (int i = 0; i < k - 1; i++) {
                currNode = leftNode.next;
                leftNode.next = leftNode.next.next;
                currNode.next = prevNode.next;
                prevNode.next = currNode;
            }
            prevNode = leftNode;
            leftNode = leftNode.next;
        }
        return dummyHead.next;
    }
}
