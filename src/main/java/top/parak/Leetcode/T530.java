package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-14
 * @apiNote 530. 二叉搜索树的最小绝对差
 */
public class T530 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode prev = null;
    private int delta = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return delta;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev != null && root.val - prev.val < delta) {
            delta = root.val - prev.val;
        }
        prev = root;
        dfs(root.right);
    }

}
