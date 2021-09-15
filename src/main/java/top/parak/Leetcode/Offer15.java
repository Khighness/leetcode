package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-28
 * @apiNote 剑指 Offer 15. 二进制中1的个数
 */
public class Offer15 {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n = n & (n - 1);
        }
        return ans;
    }
}
