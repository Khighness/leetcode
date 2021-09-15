package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-10-02
 * @apiNote 908. 最小差值 I
 */
public class T908 {

    public int smallestRangeI(int[] A, int K) {
        if (A.length == 1) return 0;
        int max = A[0], min = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) max = A[i];
            if (A[i] < min) min = A[i];
        }
        if (max - min <= 2 * K) return 0;
        else return max - min  - 2 * K;
    }

}
