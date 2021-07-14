package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/25 21:27
 * @apiNote 剑指 Offer 27. 二叉树的镜像
 */

import javax.swing.tree.TreeNode;

/**
 * Problem:
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Offer27 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 前序遍历
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);
        return root;
    }

}
