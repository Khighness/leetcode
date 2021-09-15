package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-22
 * @apiNote 面试题 02.03. 删除中间节点
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
