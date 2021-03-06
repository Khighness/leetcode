package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2021-08-21
 * @apiNote 54. 螺旋矩阵
 */
public class T54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            for (int i = l; i <= r; i++) res.add(matrix[t][i]);
            if (++t > b) break;
            for (int i = t; i <= b; i++) res.add(matrix[i][r]);
            if (--r < l) break;
            for (int i = r; i >= l; i--) res.add(matrix[b][i]);
            if (--b < t) break;
            for (int i = b; i >= t; i--) res.add(matrix[i][l]);
            if (++l > r) break;
        }
        return res;
    }
}
