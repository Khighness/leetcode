package top.parak.Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author KHighness
 * @since 2020/11/14
 * @apiNote 337. 打家劫舍 III
 */

public class T337 {

    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rob(TreeNode root) {
        int[] ans = dp(root);
        return Math.max(ans[0], ans[1]);
    }

    /**
     * dp[0]表示抢root得到的最大金额
     * dp[1]表示不抢root得到的最大金额
     */
    public int[] dp(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // 抢，下家不抢
        int dp_0 = root.val + left[1] + right[1];
        // 不抢，下家取最大
        int dp_1 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{dp_0, dp_1};
    }
}
