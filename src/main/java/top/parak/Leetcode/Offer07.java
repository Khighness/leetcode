package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-28
 * @apiNote 重建二叉树
 */
public class Offer07 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 前序遍历 => [root, {leftTree}, {rightTree}] => [root, startPre...endPre]
     * 中序遍历 => [{leftTree}, root, {rightTree}] => [startIn ... i ... endIn]
     * 遍历求出中序遍历的根节点索引 i
     * 左子树前序遍历：最左索引 = startPre + 1，最右索引 = startPre + (i - startIn)
     * 右子树前序遍历：最左索引 = startPre + (i - startIn) + 1，最右索引 = endPre
     * 左子树中序遍历：最左索引 = startIn，最右索引 = i - 1
     * 右子树中序遍历：最左索引 = i + 1，最右索引 = endIn
     */
    public TreeNode buildTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            // 找到中序的根节点索引
            if (in[i] == pre[startPre]) {
                root.left = buildTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = buildTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }

    // 根据后序遍历结果和中序遍历结果重建二叉树
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        return process(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    /**
     * 后序遍历 => [{leftTree}, {rightTree}，root] => [startPost...endPost, root]
     * 中序遍历 => [{leftTree}, root, {rightTree}] => [startIn ... i ... endIn]
     * 遍历求出中序遍历的根节点索引 i
     * 左子树前序遍历：最左索引 = startPost，最右索引 = startPost + (i - startIn)
     * 右子树前序遍历：最左索引 = startPost + (i - startIn) + 1，最右索引 = endPost - 1
     * 左子树中序遍历：最左索引 = startPost，最右索引 = i - 1
     * 右子树中序遍历：最左索引 = i + 1，最右索引 = endIn
     */
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
