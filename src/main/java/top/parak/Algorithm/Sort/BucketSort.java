package top.parak.Algorithm.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author KHighness
 * @since 2020-03-11
 * @apiNote 桶排序
 */
public class BucketSort {

    public static void sort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int value : arr) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        // 桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        // 将每个元素放入桶
        for (int value : arr) {
            int num = (value - min) / (arr.length);
            bucketArr.get(num).add(value);
        }

        // 对每个桶进行排序
        for (ArrayList<Integer> integers : bucketArr) {
            Collections.sort(integers);
        }

        // 复制到原数组
        int index = 0;
        for (ArrayList<Integer> bucket : bucketArr) {
            for (Integer i : bucket) {
                arr[index++] = i;
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
        test(80000000);
    }

}
