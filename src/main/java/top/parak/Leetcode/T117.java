package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-31
 * @apiNote 117. 填充每个节点的下一个右侧节点指针 II
 */
public class T117 {

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
    };

    public Node connect(Node root) {
        if (root == null) return root;
        Node curr = root;
        while (curr != null) {
            // 伪节点
            Node dummy = new Node(0);
            Node prev = dummy;
            // 使用当前层遍历下一层，生成链表
            while (curr != null) {
                // 左
                if (curr.left != null) {
                    prev.next = curr.left;
                    prev = prev.next;
                }
                // 右
                if (curr.right != null) {
                    prev.next = curr.right;
                    prev = prev.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }
}
