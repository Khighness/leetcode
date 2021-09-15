package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-17
 * @apiNote 1367. 二叉树中的列表
 */
public class T1367 {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        return process(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean process(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        return head.val == root.val && (process(head.next, root.left) || process(head.next, root.right));
    }
}
