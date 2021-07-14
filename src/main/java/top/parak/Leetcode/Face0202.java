package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/25 20:19
 * @apiNote 面试题 02.02. 返回倒数第 k 个节点
 */

/**
 * Problem:
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 */
public class Face0202 {

     //Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public int kthToLast(ListNode head, int k) {
        ListNode  firstNode = head, KNode = head;
        while (k != 0) {
            firstNode = firstNode.next;
            k--;
        }
        while (firstNode != null) {
            firstNode = firstNode.next;
            KNode = KNode.next;
        }
        return KNode.val;
    }
}
