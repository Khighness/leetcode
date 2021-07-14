package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/29 20:53
 * @apiNote 145. 二叉树的后序遍历
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * 给定一个二叉树，返回它的 后序 遍历。
 */
public class T145 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }
}
