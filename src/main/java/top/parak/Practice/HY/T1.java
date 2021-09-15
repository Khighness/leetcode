package top.parak.Practice.HY;

/**
 * @author KHighness
 * @since 2021-08-26
 */
public class T1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 将矩阵按照从外向里以顺时针的顺序变换成一维数组
     * @param matrix int整型二维数组 矩阵
     * @return int整型一维数组
     */
    public int[] matrixChange (int[][] matrix) {
        // write code here
        int l = 0, t = 0, r = matrix[0].length - 1, b = matrix.length - 1;
        int k = 0;
        int[] ans = new int[(b + 1) * (r + 1)];
        while (l <= r && t <= b) {
            for (int i = l; i <= r; i++) ans[k++] = matrix[t][i];
            if (++t > b) break;
            for (int i = t; i <= b; i++) ans[k++] = matrix[i][r];
            if (--r < l) break;
            for (int i = r; i >= l; i--) ans[k++] = matrix[b][i];
            if (--b < t) break;
            for (int i = b; i >= t; i--) ans[k++] = matrix[i][l];
            if (++l > r) break;
        }
        return ans;
    }
}
