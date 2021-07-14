package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/25 21:17
 * @apiNote 面试题 04.02. 最小高度树
 */

/**
 * Problem:
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 */
public class Face0402 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length - 1);
    }

    public TreeNode recursion(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (right - left) / 2 + left;
        TreeNode root = new TreeNode(nums[mid]);
        // 左子数组[left, mid - 1]构建左子树
        // 右子数组[mid + 1, right]构建右子树
        root.left = recursion(nums, left, mid - 1);
        root.right = recursion(nums, mid + 1, right);
        return root;
    }

}
