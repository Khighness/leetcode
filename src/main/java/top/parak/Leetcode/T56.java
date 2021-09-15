package top.parak.Leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author KHighness
 * @since 2021-09-15
 * @apiNote 56. 合并区间
 */
public class T56 {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int index = -1;
        int[][] res = new int[arr.length][2];
        for (int[] a : arr) {
            if (index == -1 || a[0] > res[index][1]) {
                res[++index] = a;
            }
            if (a[1] > res[index][1]) {
                res[index][1] = a[1];
            }
        }
        return Arrays.copyOf(res, index+1);
    }
}
