package top.parak.Algorithm.Search;

/**
 * @author KHighness
 * @date 2021/3/11 16:25
 * @apiNote 线性查找
 */

public class SeqSearch {

    public static int search(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        throw new RuntimeException("Not Found");
    }

}
