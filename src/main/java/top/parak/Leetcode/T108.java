package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-15
 * @apiNote 108. 将有序数组转换为二叉搜索树
 */

/**
 * Problem:
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 */
public class T108 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    private TreeNode process(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = process(nums, left, mid - 1);
        root.right = process(nums, mid + 1, right);
        return root;
    }

    // 根据后续重建
//    private TreeNode process(int[] nums, int L, int R) {
//        if (L > R) return null;
//        int rootVal = nums[R];
//        TreeNode root = new TreeNode(rootVal);
//        if (L == R) return root;
//        // 寻找右子树第一个节点(大于根节点)
//        //
//        int M = L;
//        // 直接遍历
//        for (int i = L; i <= R; i++) {
//            if (nums[i] > rootVal) {
//                M = i;
//            }
//        }
//        // 二分查找
//        int low = L - 1, high = R -1;
//        while (low <= high) {
//            int mid = low + ((high - low) >> 1);
//            if (nums[mid] < rootVal) {
//                low = mid + 1;
//                M = mid;
//            } else {
//                high = mid - 1;
//            }
//        }
//        root.left = process(nums, L, M - 1);
//        root.right = process(nums, M, R - 1);
//        return root;
//    }
}
