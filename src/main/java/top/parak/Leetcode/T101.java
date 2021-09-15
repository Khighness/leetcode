package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-10
 * @apiNote 101. 对称二叉树
 */
public class T101 {
    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return process(root.left, root.right);
    }

    public boolean process(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 != null && root2 != null && root1.val == root2.val)
            return process(root1.left, root2.right) && process(root1.right, root2.left);
        return false;
    }
}
