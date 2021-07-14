package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/9
 * @apiNote 235. 二叉搜索树的最近公共祖先
 */

/**
 * Problem:
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution:
 * 二叉搜索树，可以通过寻找根结点到两个结点的路径中，寻找两个路径的最远共同结点
 */
public class T235 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = getPath(root, p);
        List<TreeNode> path2 = getPath(root, q);
        TreeNode res = null;
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) == path2.get(i)) {
                res = path2.get(i);
            } else {
                break;
            }
        }
        return res;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new LinkedList<>();
        TreeNode temp = root;
        while (temp != target) {
            path.add(temp);
            if (temp.val > target.val) {
                temp = temp.left;
            } else  {
                temp = temp.right;
            }
        }
        path.add(temp);
        return path;
    }

}
