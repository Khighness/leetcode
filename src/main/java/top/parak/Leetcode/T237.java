package top.parak.Leetcode;

/**
 * @author: KHighness
 * @date: 2020/9/23 12:35
 * @apiNote: 237. 删除链表中的节点
 */

/**
 * Problem:
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为要被删除的节点 。
 */
public class T237 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
