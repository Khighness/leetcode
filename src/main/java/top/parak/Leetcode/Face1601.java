package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/12/2
 * @apiNote 面试题 16.01. 交换数字
 */

/**
 * Problem:
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 */
public class Face1601 {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[1];
        numbers[0] ^= numbers[0];
        return numbers;
    }
}
