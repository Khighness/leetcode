package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KHighness
 * @since 2021-04-28
 * @apiNote
 */

/**
 * Problem:
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class Offer32_1 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * （1）特例处理：当树的根节点为空，则直接返回空列表[]
     * （2）初始化：res = [], queue = [root]
     * （3）BFS循环：当队列queue为空时跳出
     * （3.1）出队：队首元素出队，记为node
     * （3.2）添加，将node的值添加至res
     * （3.3）子结点：子节点不为空，加入队列
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
