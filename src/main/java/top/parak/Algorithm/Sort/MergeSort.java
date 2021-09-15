package top.parak.Algorithm.Sort;

/**
 * @author KHighness
 * @since 2021-03-05
 * @apiNote 归并排序
 */
public class MergeSort {

    public static void sort(int[] array) {
        int[] temp = new int[array.length];
        resolve(array, 0, array.length - 1, temp);
    }

    /**
     * 分解
     * @param array 原始数组
     */
    public static void resolve(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左递归
            resolve(array, left, mid, temp);
            // 向右递归
            resolve(array, mid + 1, right, temp);
            // 合并
            merge(array, left, mid, right, temp);
        }
    }

    /**
     * 合并
     * @param array 原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边有序序列的最后索引
     * @param temp  中转数组
     */
    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;     // 左边有序序列的初始索引
        int j = mid + 1;  // 右边有序序列的初始索引
        int t = 0;        // 指向temp的当前索引
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = array[i++];
        }
        while (j <= right) {
            temp[t++] = array[j++];
        }
        t = 0;
        int leftTemp = left;
        while (leftTemp <= right) {
            array[leftTemp++] = temp[t++];
        }
    }

    private static void test(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * n * 10);
        }
        System.out.printf("┏━━▶ %d个数据的数组\n", n);
        //System.out.println(Arrays.toString(array));
        long start = System.nanoTime();
        sort(array);
        long end = System.nanoTime();
        System.out.println("┣━━▶ 排序结果");
        //System.out.println(Arrays.toString(array));
        System.out.println("┗━━▶ 排序耗时：" + (end - start) + "ns");
    }

    public static void main(String[] args) {
        test(8);
        test(80);
        test(800);
        test(8000);
        test(80000);
        test(80000000);
    }
}
