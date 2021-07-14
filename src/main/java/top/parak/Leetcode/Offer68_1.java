package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-10
 * @apiNote 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 */

/**
 * Problem:
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */
public class Offer68_1 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
