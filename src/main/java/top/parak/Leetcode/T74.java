package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-06-17
 * @apiNote 74. 搜索二维矩阵
 */
public class T74 {

    /**
     * 以左下角为原点，建立坐标轴
     * 当前数字小于目标值，向右移动
     * 向前数字大于目标值，向上移动
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length - 1, y = 0;
        while (x >= 0 && y < matrix[0].length) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                y++;
            } else {
                x--;
            }
        }
        return false;
    }

    /**
     * 从上到下，从左到右，都是升序
     * 第一次二分，从第0列的所有行寻找合适的行row
     * 第二次二分，从row列的所有列寻找合适的列col
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            if (matrix[mid][0] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int row = l;
        if (matrix[row][0] == target) return true;
        if (matrix[row][0] > target) return false;
        l = 0; r = n - 1;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            if (matrix[row][mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int col = l;
        return matrix[row][col] == target;
    }

    public boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            if (matrix[mid / n][mid % n] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return matrix[r / n][r % n] == target;
    }

}
