package top.parak.DataStructures.HaffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author KHighness
 * @date 2021/3/12 5:20
 * @apiNote 哈夫曼树
 */

class Node implements Comparable<Node> {
    /* 结点权值 */
    int value;
    /* 左子结点 */
    Node left;
    /* 右子结点 */
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" +
                "value=" + value +
                ']';
    }

    @Override
    public int compareTo(Node o) {
        // 从小到大
        return this.value - o.value;
    }
}

public class HuffmanTree {

    public static void main(String[] args) {
        int[] array = {13, 7,8, 3, 29, 6, 1};
        preOrder(createHuffmanTree(array));
    }

    public static void preOrder(Node node) {
        System.out.println(node);
        if (node.left != null) preOrder(node.left);
        if (node.right != null) preOrder(node.right);
    }

    public static Node createHuffmanTree(int[] array) {
        List<Node> nodes = new ArrayList<>();
        for (int value : array) {
            nodes.add(new Node(value));
        }
        while (nodes.size() > 1) {
            // 排序
            Collections.sort(nodes);
            // 取出权值最小的结点
            Node leftNode = nodes.get(0);
            // 取出第二小的结点
            Node rightNode = nodes.get(1);
            // 父结点的权值
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 将parent加入到nodes
            nodes.add(parent);
        }
        return nodes.get(0);
    }

}
