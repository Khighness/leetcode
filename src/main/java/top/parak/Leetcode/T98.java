package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-11
 * @apiNote 98. 验证二叉搜索树
 */
public class T98 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int prev = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        // 当前节点必须大于中序遍历的前一个节点
        if (root.val <= prev) return false;
        prev = root.val;
        return isValidBST(root.right);
    }

}
