package top.parak.DataStructures.Tree;

/**
 * @author KHighness
 * @since 2021-03-13
 * @apiNote 二叉排序树
 */
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    /**
     * 添加结点
     * @param node
     */
    public void add(TreeNode node) {
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
    }

    /**
     * 寻找结点
     * @param value
     * @return 等于查询值值的结点
     */
    public TreeNode search(int value) {
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
    public TreeNode searchParent(int value) {
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

class BinarySortTree {
    private TreeNode root;

    /**
     * 添加结点
     * @param node
     */
    public void add(TreeNode node) {
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
    public TreeNode search(int value) {
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
    public TreeNode searchParent(int value) {
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
    public TreeNode searchMinDescendant(TreeNode node) {
        TreeNode descendant = node;
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
            TreeNode targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            // 寻找待删除结点的父亲结点
            TreeNode parentNode = searchParent(value);
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
                TreeNode descendantNode = searchMinDescendant(targetNode.right);
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

    public void inOrder() {
        if (root != null) {
            root.inOrder();
        }
    }

}

public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] array = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < array.length; i++) {
            binarySortTree.add(new TreeNode(array[i]));
        }
        binarySortTree.inOrder();
        binarySortTree.remove(2);
        binarySortTree.remove(5);
        binarySortTree.remove(9);
        binarySortTree.remove(12);
        binarySortTree.remove(7);
        binarySortTree.remove(3);
        binarySortTree.remove(10);
        binarySortTree.remove(1);
        System.out.println();
        binarySortTree.inOrder();
    }
}
