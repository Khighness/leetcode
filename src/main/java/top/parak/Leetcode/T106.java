package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-15
 * @apiNote 106. 从中序与后序遍历序列构造二叉树
 */

/**
 * Problem:
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 */
public class T106 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return process(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode process(int[] in, int startIn, int endIn, int[] post, int startPost, int endPost) {
        if (startIn > endIn || startPost > endPost) return null;
        int rootVal = post[endPost];
        TreeNode root = new TreeNode(rootVal);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == rootVal) {
                root.left = process(in, startIn, i - 1, post, startPost, startPost + i - startIn - 1);
                root.right = process(in, i + 1, endIn, post, startPost + i - startIn, endPost - 1);
                break;
            }
        }
        return root;
    }
}
