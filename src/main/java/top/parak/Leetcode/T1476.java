package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-10
 * @apiNote 子矩形查询
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
