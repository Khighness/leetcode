package top.parak.Algorithm.Sort;

import java.util.Arrays;

/**
 * @author KHighness
 * @date 2020/8/29 15:07
 * @apiNote 冒泡排序
 */

public class BubbleSort {


    /**
     * 分析：
     * 需要进行【n-1】趟排序，
     * 第i趟排序进行第【n-i】次冒泡，找到第i大的数
     * 总共进行【n*(n+1)/2】次冒泡
     *
     * 优化：
     * 设置一个标志，排好序后不再进行冒泡
     */
    private static void sort(int[] array) {
        int temp = 0;
        boolean flag = false; // 是否产生数据交换的标志
        for (int i = 0; i < array.length - 1; i++) {  // (n-1)趟排序
            for (int j = 0; j < array.length - 1 - i; j++) { // (n-i)次冒泡
                if (array[j] > array[j+1]) {
                    flag = true;
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
            if (!flag) { // 在一次排序中未发生交换，表示数组已经有序
                break;
            } else {
                flag = false;
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
