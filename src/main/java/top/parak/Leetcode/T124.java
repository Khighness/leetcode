package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-19
 * @apiNote 124. 二叉树中的最大路径和
 */
public class T124 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPathSum;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        int leftPathSum = dfs(node.left);
        int rightPathSum = dfs(node.right);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int currPathSum = node.val + leftPathSum + rightPathSum;

        // 更新答案
        maxPathSum = Math.max(maxPathSum, currPathSum);

        // 返回节点的最大贡献值，如果小于0，则不贡献
        return Math.max(node.val + Math.max(leftPathSum, rightPathSum), 0);
    }
}
