package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-14
 * @apiNote 129. 求根节点到叶节点数字之和
 */
public class T129 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int cur) {
        if (root == null)
            return;
        cur = 10 * cur + root.val;
        if (root.left == null && root.right == null)
            ans += cur;
        if (root.left != null) dfs(root.left, cur);
        if (root.right != null) dfs(root.right, cur);
    }

}
