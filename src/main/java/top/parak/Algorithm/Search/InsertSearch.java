package top.parak.Algorithm.Search;

/**
 * @author KHighness
 * @date 2021/3/11 17:55
 * @apiNote 插值查找
 */

/**
 * 线性查找能自适应性查找，查找次数小于二分。
 * 对于数据量较大，关键字分布比较哦均匀的查找表来说，采用插值查找，速度较快
 */
public class InsertSearch {

    public static int search(int[] array, int left, int right, int value) {
        if (left > right || value < array[left] || value > array[right]) {
            throw new RuntimeException("Not Found");
        }
        int mid = left + (right - left) * (value - array[left]) / (array[right] - array[left]);
        int midVal = array[mid];
        if (midVal == value) {
            return mid;
        } else if (midVal > value) {
            return search(array, left, mid - 1, value);
        } else {
            return search(array, mid + 1, right, value);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        System.out.println(search(array, 0, array.length - 1, 100));
    }
}
