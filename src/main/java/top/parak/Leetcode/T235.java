package top.parak.Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author KHighness
 * @since 2020-11-09
 * @apiNote 235. 二叉搜索树的最近公共祖先
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
