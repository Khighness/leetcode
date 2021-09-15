package top.parak.Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author KHighness
 * @since 2020-11-10
 * @apiNote 257. 二叉树的所有路径
 */
public class T257 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String > paths = new LinkedList<>();
        if (root == null) return paths;
        solution(root, "", paths);
        return paths;
    }

    public void solution(TreeNode root, String curr, List<String> paths) {
        if (root == null) return;
        curr += root.val;
        if (root.left == null && root.right == null) {
            paths.add(curr);
        } else {
            solution(root.left, curr + "->", paths);
            solution(root.right, curr + "->", paths);
        }
    }
}
