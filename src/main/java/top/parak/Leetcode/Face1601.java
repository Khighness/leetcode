package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-12-02
 * @apiNote 面试题 16.01. 交换数字
 */
public class Face1601 {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[1];
        numbers[0] ^= numbers[0];
        return numbers;
    }
}
