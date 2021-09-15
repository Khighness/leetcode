package top.parak.Leetcode;

import java.util.*;

/**
 * @author KHighness
 * @since 2020-11-25
 * @apiNote 173. 二叉搜索树迭代器
 */
public class T173 {

    public static class TreeNode {
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

        @Override
        public String toString() {
            return "TreeNode[" +
                    "val=" + val +
                    ']';
        }
    }

    public static class BSTIterator {
        private Queue<TreeNode> queue = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                if (!stack.isEmpty()) {
                    curr = stack.pop();
                    queue.offer(curr);
                    curr = curr.right;
                }
            }
        }

        public int next() {
            if (queue.peek() == null)
                return -1;
            return queue.poll().val;
        }

        public boolean hasNext() {
            return queue.peek() != null;
        }
    }

    public static TreeNode createTree(TreeNode root, int[] array, int index) {
        if (index == 0) root.val = array[0];
        int left = 2 * index + 1, right = 2 * index + 2;
        if (left < array.length) {
            root.left = new TreeNode(array[left]);
            createTree(root.left, array, left);
        }
        if (right < array.length) {
            root.right = new TreeNode(array[right]);
            createTree(root.right, array, right);
        }
        return root;
    }

    public static List<TreeNode> levelOrder(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curr = null;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            list.add(curr);
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return list;
    }

}
