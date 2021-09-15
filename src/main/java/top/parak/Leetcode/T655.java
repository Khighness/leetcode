package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2021-05-10
 * @apiNote 655. 输出二叉树
 */
public class T655 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<String>> printTree(TreeNode root) {
        // 高度
        int height = getHeight(root);
        // 宽度
        int width = (int) (Math.pow(2, height) - 1);
        // 结果
        List<List<String>> res = new ArrayList<>(height);
        // 初始化
        for (int i = 0; i < height; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                list.add("");
            }
            res.add(list);
        }
        // 前序
        process(root,0, 0, width, res);
        return res;
    }

    private void process(TreeNode root, int height, int start, int end, List<List<String>> res) {
        if (root == null || start > end) return;
        int insert = start + ((end - start) >> 1);
        res.get(height).set(insert, root.val + "");
        process(root.left, height + 1, start, insert - 1, res);
        process(root.right, height + 1, insert + 1, end, res);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
