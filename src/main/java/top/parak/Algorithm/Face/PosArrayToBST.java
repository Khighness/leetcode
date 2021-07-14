package top.parak.Algorithm.Face;

/**
 * @author KHighness
 * @since 2021-03-16
 * @apiNote 后序遍历结果还原二叉搜索树，并返回根节点
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * posArr=[L1, L2... Ln, R1, R2...Rn, Root]
 * 以上为后序遍历（左右中）结果
 * 最后一个元素为根节点Root
 * [L1-Ln]为左子树，都小于Root
 * [R1-Rn]为右子树，都大于Root
 */
public class PosArrayToBST {

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node posArrayToBST1(int[] posArr) {
        return process1(posArr, 0, posArr.length - 1);
    }

    public Node process1(int[] posArr, int L, int R) {
        if (L > R) {
            return null;
        }
        Node head = new Node(posArr[R]); // 当前头结点
        if (L == R) { // 只有一个结点
            return head;
        }
        // M为左子树的最后一个元素
        // M的初始化的值很关键
        // 可能有三种情况：
        // （1）只有左子树，M = R - 1，只需要建立左子树，因为建立右子树的时候会(R > R - 1)，直接return null
        // （2）只有右子树，M = L - 1，只需要建立右子树，因为建立左子树的时候会(L > L - 1)，直接return null
        // （3）有左右子树，左右子树都需要建
        int M = L - 1;
        for (int i = L; i < R; i++) {
            if (posArr[i] < posArr[R]) {
                M = i;
            }
        }
        head.left = process1(posArr, L, M);
        head.right = process1(posArr, M + 1, R -  1);
        return head;
    }

    public Node posArrayToBST2(int[] posArr) {
        return process1(posArr, 0, posArr.length - 1);
    }

    public Node process2(int[] posArr, int L, int R) {
        if (L > R) {
            return null;
        }
        Node head = new Node(posArr[R]); // 当前头结点
        if (L == R) { // 只有一个结点
            return head;
        }
        int M = L - 1;
        // 使用二分查找
        int left= L;
        int right= R - 1;
        while (left <= right) {
            // (left + right) / 2 可能大于Integer.MAX_VALUE。造成溢出
            int mid = left + ((right - left) >> 1);
            if (posArr[mid] < posArr[R])  {
                M = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        head.left = process2(posArr, L, M);
        head.right = process2(posArr, M + 1, R -  1);
        return head;
    }

    public List<Integer> inOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node currNode = root;
        while (currNode != null || !stack.isEmpty()) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            if (!stack.isEmpty()) {
                Node pop = stack.pop();
                list.add(pop.value);
                currNode = pop.right;
            }
        }
        return list;
    }

}
