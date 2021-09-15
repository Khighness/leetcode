package top.parak.Algorithm.Sort;

import java.util.Arrays;

/**
 * @author KHighness
 * @since 2020-08-29
 * @apiNote 选择排序
 */
public class SelectSort {

    /**
     * 分析：
     * 需要进行【n-1】趟排序
     * 每一趟选择出最小的数排在相应位置
     */
    private static void sort(int[] array) {
        int min = 0, index = 0;
        for (int i = 0; i < array.length - 1; i++) {
            min = array[i];
            for (int j = i + 1; j < array.length - 1; j++) { // 寻找最小数
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            if (i != index) {// 交换位置
                array[index] = array[i];
                array[i] = min;
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
