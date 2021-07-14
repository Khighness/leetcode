package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/25 22:44
 * @apiNote 剑指 Offer 17. 打印从1到最大的n位数
 */

/**
 * Problem:
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = max * 10 + 9;
        }
        int[] array = new int[max];
        for (int i = 0; i < max; i++) {
            array[i] = i + 1;
        }
        return array;
    }
}
