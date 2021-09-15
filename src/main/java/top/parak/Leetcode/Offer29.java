package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-09-15
 * @apiNote 剑指 Offer 29. 顺时针打印矩阵
 */
public class Offer29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int[] res = new int[(r + 1) * (b + 1)]; int index = 0;
        while (true) {
            for (int i = l; i <= r; i++) {
                res[index++] = matrix[t][i];
            }
            if (++t > b) break;
            for (int i = t; i <= b; i++) {
                res[index++] = matrix[i][r];
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) {
                res[index++] = matrix[b][i];
            }
            if (--b < t) break;
            for (int i = b; i >= t; i--) {
                res[index++] = matrix[i][l];
            }
            if (++l > r) break;
        }
        return res;
    }

}
