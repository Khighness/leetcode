package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-10
 * @apiNote 617. 合并二叉树
 */

import javax.swing.tree.TreeNode;

/**
 * Problem:
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 */
public class T617 {
    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = null;
        if (root1 != null && root2 != null) {
            root = new TreeNode(root1.val + root2.val);
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
        } else if (root1 != null) {
            root = root1;
        } else if (root2 != null) {
            root= root2;
        }
        return root;
    }

}
