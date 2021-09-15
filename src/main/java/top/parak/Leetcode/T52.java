package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-10-17
 * @apiNote 52. N皇后 II
 */
public class T52 {

    private int sum;
    private int count;
    private int array[];

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

}
