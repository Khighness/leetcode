package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-11
 * @apiNote 98. 验证二叉搜索树
 */

/**
 * Problem:
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class T98 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int prev = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        // 当前节点必须大于中序遍历的前一个节点
        if (root.val <= prev) return false;
        prev = root.val;
        return isValidBST(root.right);
    }



}
