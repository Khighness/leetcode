package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-10
 * @apiNote 剑指 Offer 68 - II. 二叉树的最近公共祖先
 */

public class Offer68_2 {
    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 后序遍历
     * <p>若root是p、q的最近公共祖先，则只可能为以下情况之一
     * <li>p、q在root的子树中，且分列在root的异侧
     * <li>p = root，且q在root的左或右子树中
     * <li>q = root，且p在root的左或右子树中
     * 寻找最近，自底向上递归，即后序遍历
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        // 左子树查询
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 右子树查询
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // p、q在root异侧
        if (left != null && right != null) return root;
        // p、q在子树同侧
        return (left != null) ? left : right;
    }

}
