package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/29 21:05
 * @apiNote 1550. 存在连续三个奇数的数组
 */

/**
 * Problem:
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：
 * 如果存在，请返回 true ；否则，返回 false 。
 */
public class T1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if ((arr[i] % 2 != 0) && (arr[i+1] % 2 != 0) && (arr[i+2] % 2 != 0)) {
                return true;
            }
        }
        return false;
    }
}
