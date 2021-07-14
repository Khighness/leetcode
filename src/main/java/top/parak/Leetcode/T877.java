package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 877. 石子游戏
 */

/**
 * Problem:
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 */
public class T877 {
    /**
     * 博弈论: 先手必胜
     * 设数组总长度为n，则n % 2 == 0
     * (1) 当先手取第一位时，剩下的位置是2 ~ n，后手能取的位置为2或n，都为偶数位置。
     * (2) 当先手取最后一位时，剩下的位置是1 ~ n - 1，后手能取的位置为1或 - 1，都为奇数位置。
     * 先手取的位置必定限制了后手能取的位置，先手只要计算好奇偶数位总和，则必赢。
     */
    public boolean stoneGame(int[] piles) {
        return true;
    }

    /**
     * 区间DP
     * dp[l][r]表示区间[l, r]，在双方都做最好选择的情况下，先手与后手的最大得分差
     * dp[1][n]>0，先手必胜，dp[1][n]，先手必败
     * 先手从左端取石子，价值为piles[l-1]，后手在[l+1, r]区间做最优决策，价值为dp[l+1][r]，差值piles[l-1] - dp[l+1][r]
     * 先手从右端取石子，价值为piles[r-1]，后手在[l, r-1]区间做最优角色，价值为dp[l][r-1]，差值piles[r-1] - dp[l][r-1]
     * 双方都想赢，都想使得分差最大，于是dp[l][r] = max(piles[l-1] - dp[l+1][r], piles[r-1] - dp[l][r-1])
     */
    public boolean stoneGame2(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) { // 枚举区间长度
            for (int l = 1; l + len - 1 <= n; l++) { // 枚举左端点
                int r = l + len - 1;
                dp[l][r] = Math.max(piles[l - 1] - dp[l + 1][r], piles[r - 1] - dp[l][r - 1]);
            }
        }
        return dp[1][n] > 0;
    }
}
