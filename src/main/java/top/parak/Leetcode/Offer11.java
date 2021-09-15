package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-09
 * @apiNote 剑指 Offer 11. 旋转数组的最小数字
 */
public class Offer11 {
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (numbers[m] > numbers[r]) { // 右边
                l = m + 1;
            }  else if (numbers[m] < numbers[r]) { // 左边
                r = m;
            } else {
                int x = l;
                for (int k = l + 1; k < r; k++) {
                    if (numbers[k] < numbers[x]) {
                        x = k;
                    }
                }
                return numbers[x];
            }
        }
        return numbers[l];
    }
}
