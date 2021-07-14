package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/12/1
 * @apiNote 面试题 02.05. 链表求和
 */

/**
 * Problem:
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 */
public class Face0205 {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return (l1 == null) ?  l2 : l1;
        }
        int carry = 0, digit = 0, value = 0;
        ListNode head = new ListNode(0), temp = head;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                value = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else {
                if (l1 != null) {
                    value = l1.val + carry;
                    l1 = l1.next;
                } else {
                    value = l2.val + carry;
                    l2 = l2.next;
                }
            }
            carry = value / 10;
            digit = value % 10;
            ListNode curr = new ListNode(digit);
            curr.next = temp.next;
            temp.next = curr;
            temp = curr;
        }
        if (carry != 0) {
            ListNode curr = new ListNode(carry);
            curr.next = temp.next;
            temp.next = curr;
        }
        return head.next;
    }
}
