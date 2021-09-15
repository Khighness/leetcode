package top.parak.DataStructures.AVLTree;

import java.util.*;

/**
 * @author KHighness
 * @since 2021-03-15
 * @apiNote ALV树
 */
class AVLNode {
    int value;
    AVLNode left;
    AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AVLNode[" +
                "value=" + value +
                ']';
    }

    /**
     * @return 当前结点的高度
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * @return 左子树的高度
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    /**
     * @return 右子树的高度
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height();
        }
    }

    /**
     * 左旋操作：
     * 对X左旋
     *             P                                P
     *            /                                /
     *           X                                X(Y)
     *         /  \        --(左旋)-->           / \
     *       lX    Y                          nX   rY
     *            / \                        /  \
     *          lY   rY                     lX  lY
     * 思路：
     * （1）新建一个结点nX，将其值设为X的值，将X的值设置为Y的值
     * （2）nX的左子设为lX，nX的右子设为lY
     * （3）X的左子设为nX，X的右子设为rY
     */
    public void leftRotate() {
        AVLNode newNode = new AVLNode(this.value);
        this.value = this.right.value;
        newNode.left = this.left;
        newNode.right = this.right.left;
        this.left = newNode;
        this.right = this.right.right;
    }

    /**
     * 右旋操作：
     * 对X右旋
     *             P                                P
     *            /                                /
     *           X                                X(Y)
     *         /  \        --(右旋)-->           /  \
     *        Y   rX                           lY   nX
     *       / \                                   / \
     *     lY  rY                                rY  rX
     * 思路：
     * （1）新建一个结点nX，将其值设为X的值，将X的值设置为Y的值
     * （2）nX的左子设为rY，nX的右子设为rX
     * （3）X的左子设为lY，X的右子设为nX
     */
    public void rightRotate() {
        AVLNode newNode = new AVLNode(this.value);
        this.value = this.left.value;
        newNode.left = this.left.right;
        newNode.right = this.right;
        this.left = this.left.left;
        this.right = newNode;
    }

    /**
     * 添加结点
     * @param node
     */
    public void add(AVLNode node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        // 如果：（右子树的高度 - 左子树的高度） > 1，左旋转
        if (rightHeight() - leftHeight() > 1) {
            // 如果：它的右子的左子树大于右子树的高度，需要对右子进行右旋操作
            if (right != null && right.rightHeight() < right.leftHeight()) {
                this.right.rightRotate();
            }
            leftRotate();
        }
        // 如果：（左子树的高度 - 右子树的高度） > 1，左旋转
        if ((leftHeight() - rightHeight()) > 1) {
            // 如果：它的左子的右子树高度大于左子树的高度，需要先对左子进行左旋操作
            if (left != null && left.rightHeight() > left.leftHeight()) {
                this.left.leftRotate();
            }
            rightRotate();
        }
    }

    /**
     * 寻找结点
     * @param value
     * @return 等于查询值值的结点
     */
    public AVLNode search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 寻找节点的父亲
     * @param value
     * @return 等于查询值的结点的父亲
     */
    public AVLNode searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.value > value && this.left != null) {
                return this.left.searchParent(value);
            } else if (this.value <= value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    public void inOrder() {
        if (this.left != null) this.left.inOrder();
        System.out.print(this.value + " ");
        if (this.right != null) this.right.inOrder();
    }
}

class AVLTree {
    private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }

    /**
     * 添加结点
     * @param node
     */
    public void add(AVLNode node) {
        if (root == null) {
            root = node;
            return;
        }
        root.add(node);
    }

    /**
     * 寻找结点
     * @param value
     * @return 等于查询值值的结点
     */
    public AVLNode search(int value) {
        if (root == null) {
            return null;
        }
        return root.search(value);
    }

    /**
     * 寻找节点的父亲
     * @param value
     * @return 等于查询值的结点的父亲
     */
    public AVLNode searchParent(int value) {
        if (root == null) {
            return null;
        }
        return root.searchParent(value);
    }

    /**
     * 寻找结点的最小后裔
     * @param node
     * @return 结点的最小后裔
     */
    public AVLNode searchMinDescendant(AVLNode node) {
        AVLNode descendant = node;
        while (descendant.left != null) {
            descendant = descendant.left;
        }
        return descendant;
    }

    /**
     * 删除结点
     * 第一种：删除叶子结点
     * （1）寻找要删除的结点targetNode
     * （2）寻找targetNode的父结点parentNode
     * （3）确定targetNode是parent的左子结点还是右子结点
     * （4）根据（3）的结果
     *     左子结点 => parentNode.left = null
     *     右子结点 => parentNode.right = null
     * 第二种：删除只有一颗子树的结点
     * （1）寻找要删除的结点targetNode
     * （2）寻找targetNode的父结点parentNode
     * （3）确定targetNode是parent的左子结点还是右子结点
     * （4）确定targetNode的子结点是左子结点还是右子结点
     * （5）根据（3）（4）的结果
     *      左左 => parentNode.left = targetNode.left
     *      左右 => parentNode.left = targetNode.right
     *      右左 => parentNode.right = targetNode.left
     *      右右 => parentNode.right = targetNode.right
     *     注意，当待删除结点为根节点时，让根节点指向存在的后裔即可
     *  第三种：删除有两颗子树的结点
     * （1）寻找要删除的结点targetNode
     * （2）寻找targetNode的父结点parentNode
     * （3）从target的右子树找到最小的结点，记为tempNode
     * （4）将tempNode的值传递给父亲，然后自杀
     *      targetNode.value = tempNode.value
     *      tempNode =  null
     */
    public void remove(int value) {
        if (root == null) {
            return;
        } else {
            // 寻找待删除结点
            AVLNode targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            // 寻找待删除结点的父亲结点
            AVLNode parentNode = searchParent(value);
            // 如果只有一个结点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            // 待删除结点没有后裔
            if (targetNode.left == null && targetNode.right == null) {
                if (targetNode == parentNode.left) {
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }
            }
            // 待删除结点有两个儿子
            else if (targetNode.left != null && targetNode.right != null) {
                // 寻找右子树的最小结点或者左子树的最大结点
                AVLNode descendantNode = searchMinDescendant(targetNode.right);
                int newVal = descendantNode.value;
                remove(newVal);
                targetNode.value = newVal;
            }
            // 待删除结点有一个儿子
            else {
                if (targetNode.left != null) {
                    if (parentNode != null) {
                        if (targetNode == parentNode.left) {
                            parentNode.left = targetNode.left;
                        } else {
                            parentNode.right = targetNode.left;
                        }
                    } else { // 待删除结点为根节点
                        root = targetNode.left;
                    }
                } else {
                    if (parentNode != null) {
                        if (targetNode == parentNode.left) {
                            parentNode.left = targetNode.right;
                        } else {
                            parentNode.right = targetNode.right;
                        }
                    } else { // 待删除结点为根节点
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    public List<AVLNode> preOrder() {
        List<AVLNode> list = new ArrayList<>();
        Stack<AVLNode> stack = new Stack<>();
        AVLNode currNode = root;
        while (currNode != null || !stack.isEmpty()) {
            while (currNode != null) {
                stack.push(currNode);
                list.add(currNode);
                currNode = currNode.left;
            }
            if (!stack.isEmpty()) {
                AVLNode pop = stack.pop();
                currNode = pop.right;
            }
        }
        return list;
    }

    public List<AVLNode> inOrder() {
        List<AVLNode> list = new ArrayList<>();
        Stack<AVLNode> stack = new Stack<>();
        AVLNode currNode = root;
        while (currNode != null || !stack.isEmpty()) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            if (!stack.isEmpty()) {
                AVLNode pop = stack.pop();
                list.add(pop);
                currNode = pop.right;
            }
        }
        return list;
    }

    public List<AVLNode> postOrder() {
        List<AVLNode> list = new ArrayList<>();
        Stack<AVLNode> stack = new Stack<>();
        AVLNode currNode = root;
        while (currNode != null || !stack.isEmpty()) {
            while (currNode != null) {
                stack.push(currNode);
                list.add(currNode);
                currNode = currNode.right;
            }
            if (!stack.isEmpty()) {
                AVLNode pop = stack.pop();
                currNode = pop.left;
            }
        }
        Collections.reverse(list);
        return list;
    }
}

public class AVLTreeDemo {

    public static void main(String[] args) {
        int[] array = {4, 3, 6, 5, 8, 7};
        AVLTree avlTree = new AVLTree();
        for (int a : array) {
            avlTree.add(new AVLNode(a));
        }
        avlTree.inOrder().stream().forEach(System.out::println);
        System.out.println("树的高度 = " + avlTree.getRoot().height());
        System.out.println("树的左子树高度 = " + avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度 = " + avlTree.getRoot().rightHeight());
    }
}
