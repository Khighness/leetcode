package top.parak.Leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author KHighness
 * @since 2021-07-24
 * @apiNote 199. 二叉树的右视图
 */
public class T199 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                TreeNode curr = queue.poll();
                if (i == size) res.add(curr.val);
                if (curr.right != null) queue.add(curr.right);
                if (curr.left != null) queue.add(curr.left);
            }
        }
        return res;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    /**
     * DFS，按照父->右->左的顺序遍历，每一层第一个节点即为最右边的节点
     */
    private void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) return;
        if (res.size() == depth) {
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth, res);
        dfs(root.left, depth, res);
    }
}
