package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-18
 * @apiNote 剑指 Offer 46. 把数字翻译成字符串
 */
public class Offer46 {
    /**
     * 动态规划
     * dp[i]表示以i结尾的字符串的翻译方法数量
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            String sub = s.substring(i - 2, i);
            if (sub.compareTo("10") >= 0 && sub.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
