package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/29 21:09
 * @apiNote 1551. 使数组中所有元素相等的最小操作数
 */

/**
 * Problem:
 * 存在一个长度为 n 的数组 arr ，其中 arr[i] = (2 * i) + 1 （ 0 <= i < n ）。
 * 一次操作中，你可以选出两个下标，记作 x 和 y （ 0 <= x, y < n ）并使 arr[x] 减去 1 、arr[y] 加上 1 （即 arr[x] -=1 且 arr[y] += 1 ）。
 * 最终的目标是使数组中的所有元素都 相等 。题目测试用例将会 保证 ：在执行若干步操作后，数组中的所有元素最终可以全部相等。
 * 给你一个整数 n，即数组的长度。请你返回使数组 arr 中所有元素相等所需的 最小操作数 。
 */

/**
 * Solution:
 * 两个数，一个+1，一个-1，最终数组和不变
 * SUM = (n-1)(i=0)∑(2 * i + 1) = 2 * (0 + n - 1) * n / 2 + n = n^2
 * AVG = SUM / n = n
 * 最终数组的元素值都为AVG
 * 由于+1次数=-1次数，所有只用记录-1次数，即数组元素大于AVG的情况
 */
public class T1551 {
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
