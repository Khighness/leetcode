package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-12
 * @apiNote 96. 不同的二叉搜索树
 */

/**
 * Problem:
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class T96 {
    /**
     * dp[i]: 用连着的i个数，构建出的BST种类
     * 假设i个节点构建二叉树，
     * 一个节点为根节点，剩下i-1个节点构建子树
     * (1) 左子树分配0个，右子树分配i-1个
     * (2) 左子树分配1个，右子树分配i-1-1个
     * ...
     * (3) 左子树分配i-1个，右子树分配0个
     * 转台转移方程：dp[i] = ∑ dp[j] * dp[i - j - 1] (0<=j<=i-1)
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
