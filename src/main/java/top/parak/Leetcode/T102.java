package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-15
 * @apiNote 102. 二叉树的层序遍历
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class T102 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        process(root, 0, res);
        return res;
    }

    private void process(TreeNode root, int curr, List<List<Integer>> res) {
        if (root == null) return;
        if (res.size() <= curr) res.add(new ArrayList<>());
        res.get(curr).add(root.val);
        process(root.left, curr + 1, res);
        process(root.right, curr + 1, res);
    }
}
