package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-14
 * @apiNote 114. 二叉树展开为链表
 */

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class T114 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                list.add(curr);
                stack.add(curr);
                curr = curr.left;
            }
            if (!stack.isEmpty()) {
                curr = stack.pop().right;
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
        list.get(list.size() - 1).left = null;
    }

    /**
     * 1. 将左子树插入到右子树的地方
     * 2. 将原来的右子树接到左子树的最右边节点
     * 3. 考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为null
     */
    public void flatten2(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode prev = root.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
