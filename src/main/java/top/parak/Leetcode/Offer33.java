package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-10
 * @apiNote 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return process(postorder, 0, postorder.length - 1);
    }

    private boolean process(int[] post, int start, int end) {
        if (start >= end) return true;
        // 从最左边开始走，若能达到end说明OK
        int left = start;
        // 左子树
        while (post[left] < post[end]) left++;
        // 分界点
        int right = left;
        // 右子树
        while (post[left] > post[end]) left++;
        return left == end // 判断是否到达
                && process(post, start, right - 1) // 判断左子树
                && process(post, right, end - 1);  // 判断右子树
    }
}
