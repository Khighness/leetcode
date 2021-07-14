package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/27
 * @apiNote 226. 翻转二叉树
 */

import javax.swing.tree.TreeNode;

/**
 * Problem:
 * 翻转一棵二叉树。
 */
public class T226 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        // 从上而下
        if (root == null)
            return root;
        else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
