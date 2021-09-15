package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-11
 * @apiNote 92. 反转链表 II
 */
public class T92 {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 伪头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 左前节点，左节点
        ListNode prevNode = dummyHead, leftNode = head;
        // 移动到相应位置
        for (int i = 0; i < left - 1; i++) {
            prevNode = prevNode.next;
            leftNode = leftNode.next;
        }
        // 头插法
        ListNode next = null;
        for (int i = 0; i < (right - left); i++) {
            // 断开leftNode.next节点
            next = leftNode.next;
            leftNode.next = leftNode.next.next;
            // 将断开节点接入leftNode的前面
            next.next = prevNode.next;
            prevNode.next = next;
        }
        return dummyHead.next;
    }

}
