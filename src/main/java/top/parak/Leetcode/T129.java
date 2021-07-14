package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-14
 * @apiNote 129. 求根节点到叶节点数字之和
 */

import java.util.UUID;

/**
 * Problem:
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 */
public class T129 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int ans = 0;

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
