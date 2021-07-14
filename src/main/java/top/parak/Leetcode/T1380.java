package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/1 1:07
 * @apiNote 1380. 矩阵中的幸运数
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 * - 在同一行的所有元素中最小
 * - 在同一列的所有元素中最大
 */

/**
 * Solution:
 * 寻找每一行的最小值，看是否那一列有比它更大的值
 */
public class T1380 {

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        // 矩阵行数，列数
        int rowNum = matrix.length, colNum = matrix[0].length;
        for(int i = 0; i < rowNum; i++){
            int min = matrix[i][0];
            int minIndex = 0;
            for(int j = 1; j < colNum; j++){
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                    minIndex = j;
                }
            }
            int maxIndex;
            for(maxIndex = 0; maxIndex < rowNum; maxIndex++){
                if(matrix[maxIndex][minIndex] > min) break;
            }
            if(maxIndex == rowNum) list.add(min);
        }
        return list;
    }

    public static void main(String[] args) {
    }

}
