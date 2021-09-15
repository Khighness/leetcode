package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-25
 * @apiNote 剑指 Offer 17. 打印从1到最大的n位数
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
