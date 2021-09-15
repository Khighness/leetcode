package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-17
 * @apiNote 面试题 04.10. 检查子树
 */
public class Face0410 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        return process(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    private boolean process(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 != null && t2 != null)
            return t1.val == t2.val && process(t1.left, t2.left) && process(t1.right, t2.right);
        else
            return false;
    }

}
