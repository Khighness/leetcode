package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-11
 * @apiNote 92. 反转链表 II
 */

import java.util.Map;

/**
 * Problem:
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
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
        T92 t92 = new T92();
        ListNode curr = t92.reverseBetween(node1, 1, 4);
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

}
