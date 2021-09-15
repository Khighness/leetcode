package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-14
 * @apiNote 100. 相同的树
 */
public class T100 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p != null && q != null && p.val != q.val)
        ||  (p != null && q == null)
        ||  (p == null && q != null))
            return false;
        if (p == null) return true;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
