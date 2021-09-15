package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-28
 * @apiNote 477. 汉明距离总和
 */
public class T477 {
    /**
     * 只关心nums中有多少数的第x位不同，不关心是哪些数。
     * 建立两个集合s0和s1，统计第x位中0的数量和1的数量，
     * 那么第x位不同数的个数为s0 * s1。
     */
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for (int x = 31; x >= 0; x--) {
            int s0 = 0, s1 = 0;
            for (int n : nums) {
                if (((n >> x) & 1) == 1) s1++;
                else s0++;
            }
            ans += s0 * s1;
        }
        return ans;
    }
}
