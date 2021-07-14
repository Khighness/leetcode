package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-12
 * @apiNote 91. 解码方法
 */

/**
 Problem:
 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 "AAJF" ，将消息分组为 (1 1 10 6)
 "KJF" ，将消息分组为 (11 10 6)

 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 题目数据保证答案肯定是一个 32 位 的整数。
 */
public class T91 {

    /**
     * 动态规划
     * dp[i]表示s的前i个字符[i~i]的解码数量
     * 状态转移
     * (1) s[i] != 0 => dp[i] += dp[i-1]
     * (2) s[i-1] == 0 && s[i-1]s[i] <= 26 => dp[i] += dp[i-2]
     */
    public int numDecodings(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (arr[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            if (i >= 2 && arr[i - 2] != '0'
                    && (arr[i - 2] - '0') * 10 + (arr[i - 1] - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
