package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-10
 * @apiNote 剑指 Offer 28. 对称的二叉树
 */

/**
 * Problem:
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class Offer28 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return process(root.left, root.right);
    }

    private boolean process(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 != null && root2 != null && root1.val == root2.val)
            return process(root1.left, root2.right) && process(root2.left, root1.right);
        return false;
    }
}
