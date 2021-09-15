package top.parak.Leetcode;

import javax.swing.tree.TreeNode;

/**
 * @author KHighness
 * @since 2021-08-14
 */
public class T865 {
    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int depth = 0;
    private TreeNode ans = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private int dfs(TreeNode node, int curr) {
        if (node == null) return curr;
        int left = dfs(node.left, curr + 1);
        int right = dfs(node.right, curr + 1);
        int max = Math.max(left, right);
        depth = Math.max(depth, max);
        if (left == depth && right == depth) {
            ans = node;
        }
        return max;
    }
}
