package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-10-01
 * @apiNote 977. 有序数组的平方
 */
public class T977 {

    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        sort(A);
        return A;
    }

    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertValue = array[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            array[insertIndex + 1] = insertValue;
        }
    }

}
