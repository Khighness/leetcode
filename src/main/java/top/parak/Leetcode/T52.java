package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/10/17
 * @apiNote 52. N皇后 II
 */

/**
 * Problem:
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class T52 {

    int sum;
    int count;
    int array[];

    public int totalNQueens(int n) {
        this.sum = 0;
        this.count = n;
        this.array = new int[n];
        putQueen(0);
        return sum;
    }

    public void putQueen(int n) {
        if (n == count) {
            sum++;
            return;
        } else {
            for (int i = 0; i < count; i++) {
                array[n] = i;
                if (checkQueen(n)) {
                    putQueen(n+1);
                }
            }
        }
    }

    public boolean checkQueen(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T52 t52 = new T52();
        System.out.println(t52.totalNQueens(8));
    }

}
