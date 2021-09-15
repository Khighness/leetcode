package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-06-17
 * @apiNote 378. 有序矩阵中第 K 小的元素
 */
public class T378 {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n - 1][n - 1];
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (check(matrix, m, k, n)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean check(int[][] matrix, int m, int k, int n) {
        int i = n - 1, j = 0, num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= m) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

}
