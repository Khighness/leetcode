package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/1 17:18
 * @apiNote 206. 反转链表
 */

import java.util.List;

/**
 * Problem:
 * 反转一个单链表。
 */
public class T206 {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 头插法
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = new ListNode(0);
        ListNode temp = head, next = null;
        while (temp != null) {
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        return reverseHead.next;
    }

    // 转向阀
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
