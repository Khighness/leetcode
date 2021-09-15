package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-29
 * @apiNote 剑指 Offer 26. 树的子结构
 */
public class Offer26 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val)
            return false;
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
