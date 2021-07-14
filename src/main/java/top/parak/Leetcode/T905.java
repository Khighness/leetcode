package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/2 23:37
 * @apiNote 905. 按奇偶排序数组
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 */
public class T905 {
    public int[] sortArrayByParity(int[] A) {
        List<Integer> odd = new LinkedList<>();
        List<Integer> even = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                even.add(A[i]);
            } else {
                odd.add(A[i]);
            }
        }
        even.addAll(odd);
        return even.stream().mapToInt(Integer::valueOf).toArray();
    }
}
