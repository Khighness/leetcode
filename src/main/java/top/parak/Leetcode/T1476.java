package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021/3/10
 * @apiNote 子矩形查询
 */

/**
 * Problem:
 * 请你实现一个类 SubrectangleQueries ，它的构造函数的参数是一个 rows x cols 的矩形（这里用整数矩阵表示），并支持以下两种操作：
 *
 * 1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 * 用newValue 更新以 (row1,col1) 为左上角且以 (row2,col2) 为右下角的子矩形。
 *
 * 2. getValue(int row, int col)
 * 返回矩形中坐标 (row,col) 的当前值。
 */
public class T1476 {

    class SubrectangleQueries{
        private int[][] rectangle;

        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            if (rectangle != null) {
                for (int i = row1; i <= row2; i++) {
                    for (int j = col1; j <= col2; i++) {
                        rectangle[i][j] = newValue;
                    }
                }
            }
        }

        public int getValue(int row, int col) {
            if (rectangle != null) {
                return rectangle[row][col];
            }
            return -1;
        }
    }

}
