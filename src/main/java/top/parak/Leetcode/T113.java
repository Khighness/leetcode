package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-14
 * @apiNote 113. 路径总和 II
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 */
public class T113 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) return;
        path.offerLast(root.val);
        int next = targetSum - root.val;
        if (root.left == null && root.right == null && next == 0)
            res.add(new LinkedList<>(path));
        if (root.left != null) dfs(root.left, next);
        if (root.right != null) dfs(root.right, next);
        path.pollLast();
    }

}
