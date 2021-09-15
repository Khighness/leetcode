package top.parak.Algorithm.Sort;

import java.util.Arrays;

/**
 * @author KHighness
 * @since 2020-08-29
 * @apiNote 希尔排序
 */
public class ShellSort {

    /**
     * 冒泡法
     */
    public static void swapSort(int[] array) {
        int temp = 0;
        for (int gap = array.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j+gap]) {
                        temp = array[j];
                        array[j] = array[j+gap];
                        array[j+gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 插入法
     */
    public static void insertSort(int[] array) {
        for (int gap = array.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int insertValue = array[i];
                int insertIndex = i - gap;
                while (insertIndex >= 0 && insertValue < array[insertIndex]) {
                    array[insertIndex + gap] = array[insertIndex];
                    insertIndex -= gap;
                }
                array[insertIndex + gap] = insertValue;
            }
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
        //swapSort(array);
        insertSort(array);
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
