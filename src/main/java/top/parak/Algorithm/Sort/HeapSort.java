package top.parak.Algorithm.Sort;

import java.util.Arrays;

/**
 * @author KHighness
 * @date 2021/3/12 12:22
 * @apiNote 堆排序
 */

/**
 * 升序：大根堆
 * 降序：小根堆
 */
public class HeapSort {

    /**
     * 过程：
     * 1、将待排序列构造成一个大顶堆
     * 2、此时。整个序列的最大值就是堆顶的根结点
     * 3、将其与莫为元素进行交换，此时末尾就为最大值
     * 4、然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值
     * 如此反复执行，便能得到一个有序序列。
     */
    public static void sort(int[] array) {
        // 将无序序列构建成堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            // 从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(array, i, array.length);
        }
        // 将堆顶元素与末尾元素交换，将最大元素沉到数组末端
        // 重新调整结构，使其满足堆定义，然后继续通常交换堆顶元素与当前末尾元素
        // 反复执行调整+交换步骤，直到整个序列有序。
        for (int j = array.length - 1; j >= 0; j--) {
            int temp = array[j];
            array[j] = array[0];
            array[0] = temp;
            adjustHeap(array, 0, j);
        }
    }

    /**
     * 数组 -> 大顶堆
     * 完成将以i对应的非叶子结点的子树调整成大顶堆
     * @param array  待调整数组
     * @param i      表示非叶子结点在数组中的索引
     * @param length 表示对多少个元素进行调整，length逐渐减少
     */
    public static void adjustHeap(int[] array, int i, int length) {
        // 取出当前元素值
        int temp = array[i];
        // 开始调整，k= i * 2 + 1是i结点的左子结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 比较左子结点和右子结点
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++; // 让k指向较大的子结点
            }
            if (array[k] > temp) {   // 子结点大于父结点
                array[i] = array[k]; // 把较大的值赋给当前结点
                i = k;               // 让k所在位置成为当前结点，继续循环比较
            } else {
                break;
            }
        }
        // 循环结束之后，将temp值放到调整后的位置
        array[i] = temp;
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
    }
}
