package top.parak.Leetcode;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KHighness
 * @since 2021-09-14
 * @apiNote 剑指 Offer 37. 序列化二叉树
 */
public class Offer37 {
    // Definition for a binary tree node.
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder builder = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                builder.append(node.val).append(',');
                queue.add(node.left);
                queue.add(node.right);
            } else {
                builder.append("null").append(',');
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(']');
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] arr = data.substring(1, data.length() - 1).split(",");
        if (arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 左子节点
            if (!arr[++index].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(arr[index]));
                queue.add(node.left);
            }
            // 右子节点
            if (!arr[++index].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(arr[index]));
                queue.add(node.right);
            }
        }
        return root;
    }

}
