package top.parak.Leetcode;

import java.util.List;

/**
 * @author KHighness
 * @since 2021-07-17
 * @apiNote 139. 单词拆分
 */
public class T139 {
    /**
     * 完全背包问题，能否用wordDict中的单词组成s
     * dp[i]表示以i结尾的字符串能否被wordDict组合而成
     * 求组合数：外层for遍历背包，内层for遍历物品
     * 求排列数：外层for遍历物品，内层for遍历背包
     * 对于本题，因为是求布尔类型，都无所谓了
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (String word : wordDict) {
                int size = word.length();
                if (i - size >= 0 && s.substring(i - size, i).equals(word)) {
                    dp[i] = dp[i] || dp[i - size];
                }
            }
        }
        return dp[len];
    }
}
