package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-10
 * @apiNote 814. 二叉树剪枝
 */

/**
 * Problem:
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 */
public class T814 {
    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode pruneTree(TreeNode root) {
        if (!hasOne(root)) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root;
    }

    private boolean hasOne(TreeNode root) {
        if (root == null) return false;
        if (root.val == 1) return true;
        return hasOne(root.left) || hasOne(root.right);
    }
}
