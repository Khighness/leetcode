package top.parak.Leetcode;

import java.util.Arrays;

/**
 * @author KHighness
 * @since 2021-08-09
 * @apiNote 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class Offer21 {

    public int[] exchange(int[] arr) {
        int n = arr.length, m = n / 2;
        int i = 0, j = n - 1;
        while (i < j) {
            if (arr[i] % 2 == 1) {
                i++;
            } else {
                swap(arr, i, j);
                j--;
            }
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Offer21().exchange(new int[]{1, 2, 3, 4})));
    }
}
