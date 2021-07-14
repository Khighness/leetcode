package top.parak.Leetcode;

/**
 * <p> Project: Algorithm </P>
 * <p> Package: top.parak.Leetcode </p>
 * <p> FileName: T23 <p>
 * <p> Description: <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/12/1
 * @apiNote 23. 合并K个升序链表
 */


/**
 * Problem:
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class T23 {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 分治
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int begin, int end) {
        if (begin == end) {
            return lists[begin];
        }
        int mid = begin + (end - begin) / 2;
        ListNode left = helper(lists, begin, mid);
        ListNode right = helper(lists, mid + 1, end);
        return merge(left, right);
    }

    /**
     * 合并两个有序链表
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return (l1 == null) ? l2 : l1;
        }
        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

}
