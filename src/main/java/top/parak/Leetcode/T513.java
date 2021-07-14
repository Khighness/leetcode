package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-14
 * @apiNote 513. 找树左下角的值
 */

/**
 * Problem:
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 */
public class T513 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int maxDepth = -1, maxVal = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return maxVal;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > maxDepth) {
            maxDepth = depth;
            maxVal = root.val;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
