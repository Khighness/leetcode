package top.parak.Algorithm.Sort;

import java.util.Arrays;

/**
 * @author KHighness
 * @date 2021/3/11 14:14
 * @apiNote 基数排序
 */

public class RadisSort {

    public static void sort(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][array.length];
        int[] bucketEleCount = new int[10];
        for (int i = 0, n= 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < array.length; j++) {
                int digitOfEle = array[j] / n % 10;
                bucket[digitOfEle][bucketEleCount[digitOfEle]++] = array[j];
            }
            int index = 0;
            for (int k = 0; k < bucketEleCount.length; k++) {
                if (bucketEleCount[k] != 0) {
                    for (int l = 0; l < bucketEleCount[k]; l++) {
                        array[index++] = bucket[k][l];
                    }
                }
                bucketEleCount[k] = 0;
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
