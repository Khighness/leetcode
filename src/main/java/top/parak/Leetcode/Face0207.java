package top.parak.Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KHighness
 * @since 2020/12/1
 * @apiNote 面试题 02.07. 链表相交
 */

/**
 * Problem:
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 */
public class Face0207 {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 计算两个链表长度，快慢指针
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode longHead = headA, shortHead = headB;
        int lengthA = lengthOf(headA), lengthB = lengthOf(headB);
        if (lengthA < lengthB) {
            longHead = headB;
            shortHead = headA;
        }
        int length = Math.abs(lengthA - lengthB);
        while (length-- != 0) {
            longHead = longHead.next;
        }
        while (longHead != null && shortHead != null) {
            if (longHead == shortHead) {
                return longHead;
            }
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return null;
    }

    public int lengthOf(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * set
     */
    public ListNode solution(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

}
