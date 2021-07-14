package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/23 13:53
 * @apiNote 1572. 矩阵对角线元素的和
 */

/**
 * Problem:
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
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

    public static void main(String[] args) {
        System.out.println(new T1572().diagonalSum(new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
        System.out.println(new T1572().diagonalSum(new int[][] {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        }));
    }
}
