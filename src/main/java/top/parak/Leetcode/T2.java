package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/19 18:39
 * @apiNote 2. 两数相加
 */

/**
 * Problem:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 */

public class T2 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // value：当前值， carry：进位值
        int value = ( l1.val + l2.val ) % 10,
                carry = ( l1.val+ l2.val ) / 10;
        l1 = l1.next; l2 = l2.next;
        ListNode head = new ListNode(value);
        ListNode temp = head, curr = null;
        while ( l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                value = ( l1.val + l2.val + carry ) % 10;
                carry = ( l1.val+ l2.val + carry ) / 10;
                l1 = l1.next; l2 = l2.next;
            } else if (l2 == null) {
                value = ( l1.val + carry ) % 10;
                carry = ( l1.val + carry ) / 10;
                l1 = l1.next;
            } else if (l1 == null) {
                value = ( l2.val + carry ) % 10;
                carry = ( l2.val + carry ) / 10;
                l2 = l2.next;
            }
            curr = new ListNode(value);
            temp.next = curr;
            temp = curr;
        }
        if (carry != 0) {
            curr = new ListNode(carry);
            temp.next = curr;
        }
        return head;
    }

}
