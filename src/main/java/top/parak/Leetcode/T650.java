package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-30
 * @apiNote 650. 只有两个键的键盘
 */

import java.util.UUID;

/**
 * Problem:
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 */
public class T650 {

    /**
     * 动态规划
     * dp[i]表示得到i个A需要操作的次数
     * 状态转移
     * dp[i] = dp[i的最大因子] + 1(copy) + (i - k) / k(paste);
     */
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int k = i / 2; k > 0; k--) {
                if (i % k == 0) {
                    dp[i] = dp[k] + 1 + (i - k) / k;
                    break;
                }
            }
        }
        return dp[n];
    }
}
