package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/2 1:24
 * @apiNote 876. 链表的中间结点
 */

/**
 * Problem:
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class T876 {
    //Definition for singly-linked list.
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
