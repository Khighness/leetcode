package top.parak.Leetcode;

import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-05-10
 * @apiNote 剑指 Offer 54. 二叉搜索树的第k大节点
 */
public class Offer54 {
    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthLargest(TreeNode root, int k) {
        if (root == null) return -1;
        if (--k == 0) return root.val;
        kthLargest2(root.left, k);
        kthLargest2(root.right, k);
        return -1;
    }

    // 遍历，按照后中前的顺序
    public int kthLargest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (--k == 0) return pop.val;
                curr = pop.left;
            }
        }
        return -1;
    }

}
