package top.parak.Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KHighness
 * @since 2020-10-02
 * @apiNote 面试题 02.01. 移除重复节点
 */
public class Face0201 {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode temp = head;
        while (temp.next != null) {
            ListNode curr = temp.next;
            if (set.add(curr.val)) {
                temp = curr;
            } else {
                temp.next = curr.next;
            }
        }
        temp.next = null;
        return head;
    }
}
