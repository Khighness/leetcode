package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-15
 * @apiNote 105. 从前序与中序遍历序列构造二叉树
 */
public class T105 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode process(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) return null;
        int rootVal = pre[startPre];
        TreeNode root = new TreeNode(rootVal);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == rootVal) {
                root.left = process(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = process(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }
}
