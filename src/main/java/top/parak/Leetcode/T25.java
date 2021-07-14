package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-16
 * @apiNote 25. K 个一组翻转链表
 */

/**
 * Problem:
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
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

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode head = new T25().reverseKGroup(node1, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
