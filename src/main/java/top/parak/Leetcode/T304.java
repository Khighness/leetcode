package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-25
 * @apiNote 304. 二维区域和检索 - 矩阵不可变
 */
public class T304 {

    // 一维前缀和
    static class NumMatrix1 {
        private int[][] matrix;
        private int[][] preSum;

        public NumMatrix1(int[][] matrix) {
            this.matrix = matrix;
            int m = matrix.length, n = matrix[0].length;
            preSum = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    preSum[i][j + 1] = preSum[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = 0;
            for (int i = row1; i <= row2; i++) {
                ans += preSum[i][col2 + 1] - preSum[i][col1];
            }
            return ans;
        }
    }

    // 二维前缀和
    static class NumMatrix2 {
        private int[][] matrix;
        private int[][] preSum;

        public NumMatrix2(int[][] matrix) {
            this.matrix = matrix;
            int m = matrix.length, n = matrix[0].length;
            preSum = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2 + 1][col2 + 1] - preSum[row1][col2] - preSum[row2][col1] + preSum[row1][col1];
        }
    }

}
