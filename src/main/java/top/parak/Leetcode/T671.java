package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-27
 * @apiNote 671. 二叉树中第二小的节点
 */
public class T671 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) return -1;
        int left = root.val == root.left.val ?
                findSecondMinimumValue(root.left) : root.left.val;
        int right = root.val == root.right.val ?
                findSecondMinimumValue(root.right): root.right.val;
        int min = Math.min(left, right);
        return min > 0 ? min : Math.max(left, right);
    }

}

