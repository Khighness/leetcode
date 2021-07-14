package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/12/2
 * @apiNote 654. 最大二叉树
 */

import javax.swing.tree.TreeNode;

/**
 * Problem:
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 */
public class T654 {
    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    public TreeNode process(int[] nums, int start, int end) {
        if (start > end) return null;
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = process(nums, start, maxIndex - 1);
        root.right = process(nums, maxIndex + 1, end);
        return root;
    }

}
