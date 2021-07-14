package top.parak.Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KHighness
 * @date 2020/10/2 23:07
 * @apiNote 面试题 02.01. 移除重复节点
 */

/**
 * Problem:
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 */
public class Face0201 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return head;
        Set<Integer> set = new HashSet<Integer>();
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
