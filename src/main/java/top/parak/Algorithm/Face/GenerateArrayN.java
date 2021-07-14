package top.parak.Algorithm.Face;

import java.util.Arrays;

/**
 * @author KHighness
 * @since 2021-03-16
 * @apiNote 输入一个int类型的值N，构造一个长度为N的数组arr并满足要求：
 * 对任意i < k < j，都满足arr[i] + arr[j] != 2 * arr[k]。
 */

public class GenerateArrayN {

    public int[] generate1(int size) {
        if (size == 1) {
            return new int[] { 0 };
        }
        int halfSize = (size + 1) / 2;
        int[] base = generate1(halfSize);
        int[] ans = new int[size];
        int index = 0;
        // 构造奇数
        for (; index < halfSize; index++) {
            ans[index] = base[index] * 2 + 1;
        }
        // 构造偶数
        for (int i = 0; index < size; index++, i++) {
            ans[index] = base[i] * 2;
        }
        return ans;
    }

    public int[] generate2(int size) {
        if (size == 1) {
            return new int[] { 0 };
        }
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = i * i;
        }
        return ans;
    }

    public static void main(String[] args) {
        GenerateArrayN generateArrayN = new GenerateArrayN();
        int[] array = generateArrayN.generate2(7);
        System.out.println(Arrays.toString(array));
    }
}
