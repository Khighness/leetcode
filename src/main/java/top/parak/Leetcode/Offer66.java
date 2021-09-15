package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-31
 * @apiNote 剑指 Offer 66. 构建乘积数组
 */
public class Offer66 {

    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0)
            return a;
        int len  = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = right[len - 1] = 1;
        // left[i]记录a[i]左边乘积
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        // right[i]记录a[i]右边乘积
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    public int[] constructArr2(int[] a) {
        if (a == null || a.length == 0)
            return a;
        int len  = a.length;
        int[] b = new int[len];
        b[0] = 1;
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int i = len - 2; i >= 0; i--) {
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }

}
