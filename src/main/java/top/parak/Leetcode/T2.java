package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-19
 * @apiNote 2. 两数相加
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
            } else {
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
