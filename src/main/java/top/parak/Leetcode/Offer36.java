package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-05-10
 * @apiNote 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class Offer36 {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Stack<Node> stack = new Stack<>();
        List<Node> list = new ArrayList<>();
        Node curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            if (!stack.isEmpty()) {
                Node pop = stack.pop();
                list.add(pop);
                curr = pop.right;
            }
        }
        int size = list.size();
        Node head = list.get(0);
        for (int i = 0; i < size; i++) {
            list.get(i).left = list.get(i - 1 >= 0 ? i - 1 : size - 1);
            list.get(i).right = list.get(i + 1 < size? i + 1 : 0);
        }
        return head;
    }

    public Node treeToDoublyList2(Node root) {
        if (root == null) return null;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        // 头节点，前驱节点
        Node head = null, prev = null;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            if (!stack.isEmpty()) {
                Node pop = stack.pop();
                if (head == null) { // 第一个节点
                    head = pop;
                } else {
                    prev.right = pop;
                }
                pop.left = prev;
                prev = pop;
                curr = pop.right;
            }
        }
        head.left = prev;
        prev.right = head;
        return head;
    }
}
