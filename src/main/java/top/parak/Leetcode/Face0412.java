package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-14
 * @apiNote 面试题 04.12. 求和路径
 */
public class Face0412 {
    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int count = 0;

    public int pathSum(TreeNode root, int sum) {
        int depth = getDepth(root);
        int[] path = new int[depth];
        dfs(root, sum, path, 0);
        return count;
    }

    private void dfs(TreeNode root, int sum, int[] path, int level) {
        if (root == null) return;
        path[level] = root.val;
        int temp = 0;
        for (int i = level; i >= 0; i--) {
            temp += path[i];
            if (temp == sum) {
                count++;
            }
        }
        dfs(root.left, sum, path, level + 1);
        dfs(root.right, sum, path, level + 1);
        path[level] = Integer.MIN_VALUE;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
