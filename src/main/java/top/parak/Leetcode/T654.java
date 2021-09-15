package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-12-02
 * @apiNote 654. 最大二叉树
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
