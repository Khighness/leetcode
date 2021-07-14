package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-10
 * @apiNote 655. 输出二叉树
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
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
