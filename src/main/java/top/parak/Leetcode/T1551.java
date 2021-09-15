package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-29
 * @apiNote 1551. 使数组中所有元素相等的最小操作数
 */

public class T1551 {

    /**
     * Solution:
     * 两个数，一个+1，一个-1，最终数组和不变
     * SUM = (n-1)(i=0)∑(2 * i + 1) = 2 * (0 + n - 1) * n / 2 + n = n^2
     * AVG = SUM / n = n
     * 最终数组的元素值都为AVG
     * 由于+1次数=-1次数，所有只用记录-1次数，即数组元素大于AVG的情况
     */
    public int minOperations(int n) {
        int ans = 0, avg = n, tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp = 2 * i + 1;
            if (tmp > avg) {
                ans += tmp -avg;
            }
        }
        return ans;
    }

}
