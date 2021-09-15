package top.parak.DataStructures.Tree;

import java.util.*;

/**
 * @author KHighness
 * @since 2020-09-30
 * @apiNote 二叉树
 */
class HeroNode {

    public int no;
    public String name;
    public HeroNode left;
    public HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ']';
    }

}

class BinaryTree {

    // 根节点
    public HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * @deprecated
     */
    public BinaryTree() {
    }

    /**
     * 前序遍历——递归
     * @param node 根节点
     */
    public void preOrder1(HeroNode node) {
        System.out.println(node);
        if (node.left != null) preOrder1(node.left);
        if (node.right != null) preOrder1(node.right);
    }

    /**
     * 前序遍历——非递归
     * @param node 根节点
     * @return List 将前序遍历结果存进List
     */
    public List<HeroNode> preOrder2(HeroNode node) {
        Stack<HeroNode> stack = new Stack<>();
        List<HeroNode> list = new LinkedList<>();
        HeroNode currNode = node;
        while (currNode != null || !stack.isEmpty()) {
            // 沿左子树，一路向左，直至走完
            while (currNode != null) {
                list.add(currNode);
                stack.push(currNode);
                currNode = currNode.left;
            }
            // 左边的结点走完，改变方向向右走
            if (!stack.isEmpty()) {
                currNode = stack.pop();
                currNode = currNode.right;
            }
        }
        return list;
    }

    /**
     * 中序遍历——递归
     * @param node 根节点
     */
    public void inOrder1(HeroNode node) {
        if (node.left != null) inOrder1(node.left);
        System.out.println(node);
        if (node.right != null) inOrder1(node.right);
    }

    /**
     * 中序遍历——非递归
     * @param node 根节点
     * @return List 将中序序遍历结果存进List
     */
    public List<HeroNode> inOrder2(HeroNode node) {
        Stack<HeroNode> stack = new Stack<>();
        List<HeroNode> list = new LinkedList<>();
        HeroNode currNode = node;
        while (currNode != null || !stack.isEmpty()) {
            // 沿左子树，一路向左，但是不打印经过结点的值
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            // 达到最左边，打印结点并改变方向
            if (!stack.isEmpty()) {
                currNode = stack.pop();
                list.add(currNode);
                currNode = currNode.right;
            }
        }
        return list;
    }

    /**
     * 后序遍历——递归
     * @param node 根节点
     */
    public void postOrder1(HeroNode node) {
        if (node.left != null) postOrder1(node.left);
        if (node.right != null) postOrder1(node.right);
        System.out.println(node);
    }

    /**
     * 后序遍历——非递归
     * 先遍历右，再遍历左，最后将结果反向
     * @param node 根节点
     * @return
     */
    public List<HeroNode> postOrder2(HeroNode node) {
        Stack<HeroNode> stack = new Stack<>();
        List<HeroNode> list = new LinkedList<>();
        HeroNode currNode = node;
        while (currNode != null || !stack.isEmpty()) {
            while (currNode != null) {
                list.add(currNode);
                stack.push(currNode);
                currNode = currNode.right;
            }
            if (!stack.isEmpty()) {
                currNode = stack.pop();
                currNode = currNode.left;
            }
        }
        Collections.reverse(list);
        return list;
    }

    /**
     * 前序遍历查找
     * @param node 根结点
     * @param no   查找的结点序号
     * @return
     */
    public HeroNode preOrderSearch(HeroNode node, int no) {
        // 当前结点即为所查结点
        if (node.getNo() == no) {
            return node;
        }
        // 1、判断当前结点的左子结点是否为空，如果不为空，则递归前序查找
        // 2、如果做左递归前序查找，找到结点，则返回
        HeroNode resNode = null;
        if (node.left != null) {
            resNode = preOrderSearch(node.left, no);
        }
        if (resNode != null) {
            return resNode;
        }
        // 1、左递归前序查找，找到结点，则返回，否则继续判断
        // 2、当前的结点的右子结点是否为空，如果不空，则继续向右递归前序查找
        if (node.right != null) {
            resNode = preOrderSearch(node.right, no);
        }
        return  resNode;
    }

    /**
     * 中序遍历查找
     * @param node 根节点
     * @param no   查找的结点序号
     * @return
     */
    public HeroNode inOrderSearch(HeroNode node, int no) {
        HeroNode resNode = null;
        if (node.left != null) {
            resNode = inOrderSearch(node.left, no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (node.getNo() == no) {
            return node;
        }
        if (node.right != null) {
            resNode = inOrderSearch(node.right, no);
        }
        return resNode;
    }

    /**
     * 后序遍历查找
     * @param node 根节点
     * @param no   查找的结点序号
     * @return
     */
    public HeroNode postOrderSearch(HeroNode node, int no) {
        HeroNode resNode = null;
        if (node.left != null) {
            resNode = postOrderSearch(node.left, no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (node.right != null) {
            resNode = postOrderSearch(node.right, no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (node.getNo() == no) {
            return node;
        }
        return resNode;
    }

    /**
     * 递归删除结点:
     * 1、如果删除的是叶子结点，则删除该结点
     * 2、如果删除的是非叶子结点，则删除该子树
     * 思路：
     * 首先-考虑树是否是空树，如果只有一个结点，则等价将二叉树置空
     * 1) 因为二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能判断当前结点是否需要删除结点
     * 2) 如果当前结点的左子节点不为空，并且左子节点就是要删除结点，则将this.left = null，不是则向左子树递归删除
     * 3) 如果当前结点的右子结点不为空，并且右子结点就是要删除结点。则将this.right = null，不是则向右子树递归删除
     *
     * @param node
     * @param no
     */
    public void delNode(HeroNode node, int no) {
        // 判断自己
        if (node != null && node.getNo() == no) {
            node = null;
            return;
        }
        // 判断左子结点
        if (node.left != null) {
            if (node.left.getNo() == no) { // 恰好左子结点就是需要删除结点
                node.left = null;
                return;
            } else { // 否则就递归删除
                delNode(node.left, no);
            }
        }
        // 判断右子结点
        if (node.right != null) {
            if (node.right.getNo() == no) { // 恰好右子结点就是需要删除结点
                node.right = null;
                return;
            } else { // 否则就递归删除
                delNode(node.right, no);
            }
        }
    }

    /**
     * 删除规则：
     * 删除的是是非结点，不删除子树
     * 优先使用左子结点顶替其位置，左子结点不存在则使用右子结点顶替
     * @param node
     * @param no
     * @deprecated
     */
    public void delNode2(HeroNode node, int no) {
        if (node == null) {
            throw new RuntimeException("空树不可删除");
        }
        // 判断自身是否需要删除
        if (node != null || node.getNo() == no ) {
            if (node.left != null) {
                node = new HeroNode(node.left.getNo(), node.left.getName());
                node.setLeft(node.left.left);
                node.setRight(node.left.right);
                return;
            }
            if (node.right != null) {
                node = new HeroNode(node.right.getNo(), node.right.getName());
                node.setLeft(node.right.left);
                node.setRight(node.right.right);
                return;
            }
            node = null;
            return;
        }
        // 判读左子树
        if (node.left != null) {
            delNode2(node.left, no);
        }
        if (node.right != null) {
            delNode2(node.right, no);
        }
    }

}

public class BinaryTreeDemo {

    public static void main(String[] args) {
        // 创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        // 创建节点
        HeroNode hero1 = new HeroNode(1, "宋江");
        HeroNode hero2 = new HeroNode(2, "卢俊义");
        HeroNode hero3 = new HeroNode(3, "吴用");
        HeroNode hero4 = new HeroNode(4, "公孙胜");
        HeroNode hero5 = new HeroNode(5, "关胜");
        HeroNode hero6 = new HeroNode(6, "林冲");
        HeroNode hero7 = new HeroNode(7, "秦明");
        HeroNode hero8 = new HeroNode(8, "呼延灼");
        HeroNode hero9 = new HeroNode(9, "花荣");
        // 手动创建二叉树
        hero1.setLeft(hero2);
        hero1.setRight(hero3);
        hero2.setLeft(hero4);
        hero2.setRight(hero5);
        hero3.setLeft(hero6);
        hero3.setRight(hero7);
        hero5.setRight(hero8);
        hero6.setLeft(hero9);

        // 递归遍历
        System.out.println("----------前序遍历----------");
        binaryTree.preOrder1(hero1);
//        System.out.println("----------中序遍历----------");
//        binaryTree.inOrder1(hero1);
//        System.out.println("----------后序遍历----------");
//        binaryTree.postOrder1(hero1);
//
//        // 非递归遍历
//        System.out.println("----------前序遍历----------");
//        List<HeroNode> list1 = binaryTree.preOrder2(hero1);
//        list1.stream().forEach(System.out::println);
//        System.out.println("----------中序遍历----------");
//        List<HeroNode> list2 = binaryTree.inOrder2(hero1);
//        list2.stream().forEach(System.out::println);
//        System.out.println("----------后序遍历----------");
//        List<HeroNode> list3 = binaryTree.postOrder2(hero1);
//        list3.stream().forEach(System.out::println);

        // 查找结点
//        System.out.println(binaryTree.preOrderSearch(hero1, 9));
//        System.out.println(binaryTree.inOrderSearch(hero1, 6));
//        System.out.println(binaryTree.postOrderSearch(hero1, 9));
//        binaryTree.delNode(hero1, 3);
//        System.out.println("----------删后遍历----------");
//        binaryTree.preOrder1(hero1);

    }
}
