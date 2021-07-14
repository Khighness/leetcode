package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-10-17
 * @apiNote 面试29. 顺指针打印二维数组
 */

public class Face29 {

    public void printClockwise(int[][] array) {
        int n = array.length, length = 0;
        for (int i = 0; i < (n + 1) / 2; i++) {
            length = n - 2 * i - 1;
            // 中
            if (length == 0) System.out.print(array[i][i] + " ");
            // 上
            for (int s = i; s <= i + length - 1; s++) System.out.print(array[i][s] + " ");
            // 右
            for (int r = i; r <= i + length - 1; r++) System.out.print(array[r][i + length] + " ");
            // 下
            for (int x = i + length; x >= i + 1; x--) System.out.print(array[i + length][x] + " ");
            // 左
            for (int l = i + length; l >= i + 1; l--) System.out.print(array[l][i] + " ");
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[][] {
                {1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        new Face29().printClockwise(array);
    }
}
