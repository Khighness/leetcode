package top.parak.Leetcode;

/**
 * <p> Project: Algorithm </P>
 * <p> Package: top.parak.Leetcode </p>
 * <p> FileName: Offer52 <p>
 * <p> Description:  <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/11/30
 * @apiNote 剑指 Offer 52. 两个链表的第一个公共节点
 */

/**
 * Problem:
 * 输入两个链表，找出它们的第一个公共节点。
 */

/**
 * Solution:
 * 1、得到两个链表的长度
 * 2、让长链表头先走
 * 3、两个链表一起走
 */
public class Offer52 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * <p>获取链表长度</p>
     * @param node
     * @return
     */
    public int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = length(headA), lengthB = length(headB);
        ListNode longNode = headA, shortNode = headB;
        if (lengthA < lengthB) {
            longNode = headB;
            shortNode = headA;
        }
        int length = Math.abs(lengthA - lengthB);
        while (length-- != 0) {
            longNode = longNode.next;
        }
        while (longNode != null && shortNode != null && longNode != shortNode) {
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return longNode;
    }

}
