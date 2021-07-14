package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/2 21:57
 * @apiNote 908. 最小差值 I
 */

/**
 * Problem:
 * 给你一个整数数组 A，请你给数组中的每个元素 A[i] 都加上一个任意数字 x （-K <= x <= K），从而得到一个新数组 B 。
 * 返回数组 B 的最大值和最小值之间可能存在的最小差值。
 */
public class T908 {
    public int smallestRangeI(int[] A, int K) {
        if (A.length == 1) return 0;
        int max = A[0], min = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) max = A[i];
            if (A[i] < min) min = A[i];
        }
        if (max - min <= 2 * K) return 0;
        else return max - min  - 2 * K;
    }

    public static void main(String[] args) {
        System.out.println(new T908().smallestRangeI(new int[]{2, 7, 2}, 1));
    }
}
