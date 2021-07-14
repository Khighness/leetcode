package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-14
 * @apiNote 112. 路径总和
 */

/**
 * Problem:
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。
 */
public class T112 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int next = targetSum - root.val;
        if (root.left == null && root.right == null)
            return next == 0;
        if (root.left != null && root.right != null)
            return hasPathSum(root.left, next) || hasPathSum(root.right, next);
        return root.left != null ? hasPathSum(root.left, next) : hasPathSum(root.right, next);
    }

}
