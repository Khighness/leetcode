package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-11-09
 * @apiNote 240. 搜索二维矩阵 II
 */
public class T240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
