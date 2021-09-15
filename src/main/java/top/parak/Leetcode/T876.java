package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-10-02
 * @apiNote 876. 链表的中间结点
 */
public class T876 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (length % 2 == 0) {
            length += 1;
        }
        temp = head;
        for (int i = 1; i < (length + 1) / 2; i++) {
            temp = temp.next;
        }
        return temp;
    }

}
