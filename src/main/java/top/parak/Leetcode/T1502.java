package top.parak.Leetcode;

import java.util.Arrays;

/**
 * @author KHighness
 * @since 2020/10/17
 * @apiNote 1502. 判断能否形成等差数列
 */

/**
 * Problem:
 * 给你一个数字数组 arr 。
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 */
public class T1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if ( (arr[i+1] - arr[i]) != (arr[i+2] - arr[i+1])) {
                return false;
            }
        }
        return true;
    }
}
