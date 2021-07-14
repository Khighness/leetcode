package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/22 13:17
 * @apiNote 面试题 02.03. 删除中间节点
 */

/**
 * Problem:
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 */

public class Face0203 {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 因为只给了一个节点，无法进行删除操作
    // 所有只有把自己变成下一个节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
