package top.parak.DataStructures.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <p> Project: Algorithm </P>
 * <p> Package: top.parak.DataStructures.Tree </p>
 * <p> FileName: ThreadedBinaryTreeDemo <p>
 * <p> Description: 线索化二叉树 <p>
 * <p> Created By IntelliJ IDEA </p>
 *
 * @author KHighness
 * @since 2020/10/25
 */

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        Node node6 = new Node("F");
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setRight(node6);
        for (Node node : threadedBinaryTree.inorder(node1)) {
            System.out.print(node.getData() + " ");
        }
        System.out.println();
        threadedBinaryTree.inThreadedNodes(node1);
        System.out.println("B-left: " + node2.getLeft());
        System.out.println("B-right: " + node2.getRight());
        System.out.println("D-left: " + node4.getLeft());
        System.out.println("D-right: " + node4.getRight());
    }
}

class Node {

    private String data;
    private Node left;
    private Node right;

    /**
     * 规定:
     * 1、leftType： 0表示指向的是左子树，1表示指向的是前驱结点
     * 2、rightType：0表示指向的是右子树，1表示指向的是后继结点
     */
    private int leftType;
    private int rightType;

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                '}';
    }
}

/**
 * <p>线索化二叉树的实质：
 * 将二叉树变成特殊的双向链表</p>
 */
class ThreadedBinaryTree {

    /* 线索化时记录前驱结点 */
    private Node pre = null;

    /**
     * <p>根据数组创建二叉树</p>
     * @param array
     * @param index
     * @return*
     */
    public Node createBinaryTree(String[] array, int index) {
        Node node = null;
        if (index < array.length) {
            node = new Node(array[index]);
            node.setLeft(createBinaryTree(array, 2 * index + 1));
            node.setRight(createBinaryTree(array, 2 * index + 2));
        }
        return node;
    }

    /**
     * <p>对二叉树进行中序线索化</p>
     * <ul>过程如下：</ul>
     * <li>1. 先线索化左子树</li>
     * <li>2. 线索化当前结点</li>
     * <li>3. 再线索化右子树</li>
     * @param node
     */
    public void inThreadedNodes(Node node) {
        if (node == null) {
            return;
        }

        /* 线索化左子树 */
        inThreadedNodes(node.getLeft());

        /* 处理当前结点的前驱结点 */
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        /* 处理前驱结点的后继结点 */
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        /* 让当前结点成为新的前驱结点 */
        pre = node;
        /* 线索化右子树 */
        inThreadedNodes(node.getRight());
    }

    /**
     * <p>中序遍历二叉树</p>
     * @param node
     * @return
     */
    public List<Node> inorder(Node node) {
        Stack<Node> stack = new Stack<>();
        List<Node> list = new LinkedList<>();
        Node currNode = node;
        while (currNode != null || !stack.empty()) {
           while (currNode != null) {
               stack.push(currNode);
               currNode = currNode.getLeft();
           }
           if (!stack.empty()) {
               currNode = stack.pop();
               list.add(currNode);
               currNode = currNode.getRight();
           }
        }
        return list;
    }

    /**
     * <p>前序前序线索化二叉树</p>
     * @param node
     */
    public void preThreadedNodes(Node node) {
        if (node == null) {
            return;
        }
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setLeftType(1);
        }
        preThreadedNodes(node.getLeft());
        preThreadedNodes(node.getRight());
    }

    /**
     * <p>后续线索化二叉树</p>
     * @param node
     */
    public void postThreadedNodes(Node node) {
        if (node == null) {
            return;
        }
        preThreadedNodes(node.getLeft());
        preThreadedNodes(node.getRight());
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setLeftType(1);
        }
    }

}
