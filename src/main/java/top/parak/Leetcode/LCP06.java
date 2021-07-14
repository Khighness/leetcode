package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/23 11:46
 * @apiNote LCP 06. 拿硬币
 */

/**
 * Problem:
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 */
public class LCP06 {
    public int minCount(int[] coins) {
        int ans = 0;
        for (int i = 0; i < coins.length; i++) {
            ans += coins[i] / 2 + (coins[i] % 2 == 0 ? 0 : 1);
        }
        return ans;
    }
}
