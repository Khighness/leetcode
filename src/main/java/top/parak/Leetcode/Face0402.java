package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-25
 * @apiNote 面试题 04.02. 最小高度树
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
