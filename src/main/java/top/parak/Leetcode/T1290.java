package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-25
 * @apiNote 1290. 二进制链表转整数
 */
public class T1290 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int getDecimalValue(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        return Integer.valueOf(stringBuilder.toString(), 2);
    }

}
