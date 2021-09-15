package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-10
 * @apiNote 617. 合并二叉树
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
