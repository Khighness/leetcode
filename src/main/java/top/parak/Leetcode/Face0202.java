package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-25
 * @apiNote 面试题 02.02. 返回倒数第 k 个节点
 */
public class Face0202 {

     // Definition for singly-linked list.
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public int kthToLast(ListNode head, int k) {
        ListNode firstNode = head, kNode = head;
        while (k != 0) {
            firstNode = firstNode.next;
            k--;
        }
        while (firstNode != null) {
            firstNode = firstNode.next;
            kNode = kNode.next;
        }
        return kNode.val;
    }
}
