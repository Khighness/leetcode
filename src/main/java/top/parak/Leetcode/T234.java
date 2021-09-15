package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2020-12-01
 * @apiNote 234. 回文链表
 */
public class T234 {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int len = list.size();
        for (int i = 0; i < len / 2 + ((len % 2 == 0) ? 0 : 1); i++) {
            if (list.get(i).intValue() != list.get(len - 1 - i).intValue()) {
                return false;
            }
        }
        return true;
    }

    private ListNode frontPointer;
    public boolean solution1(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(frontPointer);
    }
    public boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

}
