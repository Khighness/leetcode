package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/25 20:03
 * @apiNote 剑指 Offer 22. 链表中倒数第k个节点
 */

/**
 * Problem:
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
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
