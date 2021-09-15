package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-19
 * @apiNote 404. 左叶子之和
 */
public class T404 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 计算左叶子和和
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    // 深度优先搜索
    public int dfs(TreeNode node) {
        int res = 0;
        if (node.left != null) {
            res += isLeafCode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafCode(node.right)) {
            res += dfs(node.right);
        }
        return res;
    }

    // 判断叶子节点
    public boolean isLeafCode(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
