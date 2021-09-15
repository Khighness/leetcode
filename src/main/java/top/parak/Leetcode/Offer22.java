package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-25
 * @apiNote 剑指 Offer 22. 链表中倒数第k个节点
 */
public class Offer22 {

     // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

     // 双指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode  firstNode = head, KNode = head;
        while (k != 0) {
            firstNode = firstNode.next;
            k--;
        }
        while (firstNode != null) {
            firstNode = firstNode.next;
            KNode = KNode.next;
        }
        return KNode;
    }

}
