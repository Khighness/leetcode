package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-13
 * @apiNote 111. 二叉树的最小深度
 */

/**
 * Problem:
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class T111 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null && root.right != null)
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        return root.left != null ? minDepth(root.left) + 1 : minDepth(root.right) + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 1, 1);
    }

    private int dfs(TreeNode root, int cur, int min) {
        if (root.left == null && root.right == null) {
            min = Math.max(min, cur);
            return min;
        }
        if (root.left != null && root.right != null) {
            return Math.min(dfs(root.left, cur + 1, min), dfs(root.right, cur + 1, min));
        }
        return root.left != null ? dfs(root.left, cur + 1, min) : dfs(root.right, cur + 1, min);
    }
}
