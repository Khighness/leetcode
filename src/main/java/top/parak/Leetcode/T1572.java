package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-23
 * @apiNote 1572. 矩阵对角线元素的和
 */
public class T1572 {

    public int diagonalSum(int[][] mat) {
        int ans = 0, len = mat.length;
        for (int i = 0; i < len; i++) {
            if (2 * i + 1 == len) {
                ans += mat[i][i];
            } else {
                ans += mat[i][i] + mat[i][len - i - 1];
            }
        }
        return ans;
    }

}
