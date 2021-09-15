package top.parak.Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author KHighness
 * @since 2020-10-01
 * @apiNote 897. 递增顺序查找树
 */
public class T897 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> ints = inOrder(root);
        List<TreeNode> nodes = new LinkedList<>();
        for (int i = 0; i < ints.size(); i++) {
            nodes.add(new TreeNode(ints.get(i)));
        }
        for (int i = 0; i < ints.size() - 1; i++) {
            nodes.get(i).right = nodes.get(i + 1);
        }
        return nodes.get(0);
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        while ( currNode != null || !stack.isEmpty() ) {
            while ( currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            if (!stack.isEmpty()) {
                currNode = stack.pop();
                list.add(currNode.val);
                currNode = currNode.right;
            }
        }
        return list;
    }

}
