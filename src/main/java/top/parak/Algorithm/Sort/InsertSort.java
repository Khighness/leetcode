package top.parak.Algorithm.Sort;

import java.util.Arrays;

/**
 * @author KHighness
 * @date 2020/8/29 17:13
 * @apiNote 插入排序
 */

public class InsertSort {

    /**
     * 分析：
     * 开始，把最左边的一个数当作一个有序数组，把右边切开当作无序数组
     * 依次，把右边的无序数组中的数，插入到左边的有序数组中，完成排序
     */
    private static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 定义待插入的数
            int insertValue = array[i];
            int insertIndex = i-1;

            /**
             * 寻找insertValue的插入位置：
             * insertIndex >= 0, 保证不越界；
             * insertValue < array[insertIndex]，未找到插入位置。
             */
            while (insertIndex >= 0 && insertValue < array[insertIndex]) {
                // 向右移动左有序数组
                array[insertIndex+1] = array[insertIndex];
                insertIndex--;
            }
            // 插入数据
            array[insertIndex+1] = insertValue;
        }
    }

    private static void test(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * n * 10);
        }
//        System.out.printf("┏━━▶ %d个数据的数组\n", n);
        System.out.println(Arrays.toString(array));
        long start = System.nanoTime();
        sort(array);
        long end = System.nanoTime();
        System.out.println("┣━━▶ 排序结果");
//        System.out.println(Arrays.toString(array));
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
