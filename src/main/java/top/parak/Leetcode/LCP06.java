package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 202-09-23
 * @apiNote LCP 06. 拿硬币
 */
public class LCP06 {
    /**
     * 各堆之间不会相互影响，每一堆需要拿(x + 1) / 2次
     */
    public int minCount(int[] coins) {
        int ans = 0;
        for (int coin : coins) {
            ans += (coin + 1) /2;
        }
        return ans;
    }
}
