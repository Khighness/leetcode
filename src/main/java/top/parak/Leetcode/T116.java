package top.parak.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KHighness
 * @since 2021-07-31
 * @apiNote 116. 填充每个节点的下一个右侧节点指针
 */
public class T116 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 层次遍历
     */
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Node curr = queue.poll();
                if (i > 1) curr.next = queue.peek();
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        return root;
    }

    /**
     * 从每一层的最左边开始
     */
    public Node connect2(Node root) {
        if (root == null) return root;
        Node prev = root;
        while (prev.left != null) {
            Node curr = prev;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            prev = prev.left;
        }
        return root;
    }
}
