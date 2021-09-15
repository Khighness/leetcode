package top.parak.DataStructures.Tree;

/**
 * @author KHighness
 * @since 2020-10-23
 * @apiNote 顺序二叉树
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(array);
        arrayBinaryTree.preorder();
        arrayBinaryTree.inorder();
        arrayBinaryTree.postorder();
    }
}

/**
 * 顺序存储二叉树
 * 1) 通常只考虑完全二叉树
 * 2) 第n个元素的左子节点为 2 * n + 1
 * 3) 第n个元素的右子节点为 2 * n + 2
 * 4) 第n个元素的的父节点为 (n - 1) / 2
 */
class ArrayBinaryTree {

    private int[] array;

    public ArrayBinaryTree(int[] array) {
        this.array = array;
    }

    public void preorder() {
        this.preorder(0);
    }

    public void inorder() {
        this.inorder(0);
    }

    public void postorder() {
        this.postorder(0);
    }

    /**
     * 顺序存储二叉树的前序遍历
     * @param index 数组的下标
     */
    public void preorder(int index)  {
        if (array == null || array.length == 0) {
            throw new RuntimeException("数组为空");
        }
        // 输出当前元素
        System.out.println(array[index]);
        // 向左递归遍历
        if ((2 * index + 1) < array.length) {
            preorder(2 * index + 1);
        }
        // 向右递归遍历
        if ((2 * index + 2) < array.length) {
            preorder(2 * index + 2);
        }
    }

    /**
     * 顺序存储二叉树的中序遍历
     * @param index
     */
    public void inorder(int index) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("数组为空");
        }
        // 向左递归遍历
        if ((2 * index + 1) < array.length) {
            inorder(2 * index + 1);
        }
        // 输出当前元素
        System.out.println(array[index]);
        // 向右递归遍历
        if ((2 * index + 2) < array.length) {
            inorder(2 * index + 2);
        }
    }

    /**
     * 顺序存储二叉树的后序遍历
     * @param index
     */
    public void postorder(int index) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("数组为空");
        }
        // 向左递归遍历
        if ((2 * index + 1) < array.length) {
            postorder(2 * index + 1);
        }
        // 向右递归遍历
        if ((2 * index + 2) < array.length) {
            postorder(2 * index + 2);
        }
        // 输出当前元素
        System.out.println(array[index]);
    }

}
