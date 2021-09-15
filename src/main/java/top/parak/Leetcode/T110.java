package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-10
 * @apiNote 110. 平衡二叉树
 */
public class T110 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 前序遍历
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        return Math.abs(leftH - rightH) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
