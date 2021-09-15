package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-14
 * @apiNote 112. 路径总和
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
