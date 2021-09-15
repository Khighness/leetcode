package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-12-01
 * @apiNote 725. 分隔链表
 */
public class T725 {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 新建链表
     */
    public ListNode[] solution1(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode curr = root;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        int width = length / k, rem = length % k;
        curr = root;
        for (int i = 0; i < k; i++) {
            ListNode head = new ListNode(0), temp = head;
            for (int j = 0; j < width + (i < rem ? 1 : 0); j++) {
                temp.next = new ListNode(curr.val);
                temp = temp.next;
                curr = curr.next;
            }
            ans[i] = head.next;
        }
        return ans;
    }

    /**
     * 拆分链表
     */
    public ListNode[] solution2(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode curr = root;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        int width = length / k, rem = length % k;
        curr = root;
        for (int i = 0; i < k; i++) {
            ListNode head = curr;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; j++) {
                if (curr != null) {
                    curr = curr.next;
                }
            }
            if (curr != null) {
                ListNode prev = curr;
                curr = curr.next;
                prev.next = null;
            }
            ans[i] = head;
        }
        return ans;
    }

}
