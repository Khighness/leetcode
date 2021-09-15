package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2020-10-01
 * @apiNote 1380. 矩阵中的幸运数
 */
public class T1380 {

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        // 矩阵行数，列数
        int rowNum = matrix.length, colNum = matrix[0].length;
        for (int[] ints : matrix) {
            int min = ints[0];
            int minIndex = 0;
            for (int j = 1; j < colNum; j++) {
                if (ints[j] < min) {
                    min = ints[j];
                    minIndex = j;
                }
            }
            int maxIndex;
            for (maxIndex = 0; maxIndex < rowNum; maxIndex++) {
                if (matrix[maxIndex][minIndex] > min) break;
            }
            if (maxIndex == rowNum) list.add(min);
        }
        return list;
    }

}
