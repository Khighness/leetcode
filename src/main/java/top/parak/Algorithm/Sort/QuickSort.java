package top.parak.Algorithm.Sort;

import java.util.Arrays;

/**
 * @author KHighness
 * @date 2021/3/5 12:30
 * @apiNote 快速排序
 */

public class QuickSort {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * 思想：
     * 1. 选取pivot中心轴
     * 2. 将大于pivot的数字置于pivot的右边
     * 3. 将小于pivot的数字置于pivot的左边
     * 4. 分别左右子序列重负前三步操作
     */
    public static void sort(int[] array, int left, int right){
        if(left > right) return;
        int l = left, r = right;
        int pivot = array[left];
        while (l < r) {
            while (pivot <= array[r] && l < r) {
                r--;
            }
            while (pivot >= array[l] && l < r) {
                l++;
            }
            if (l < r) {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
        }
        // 最后将轴为与i和j相等位置的数字交换
        array[left] = array[l];
        array[l] = pivot;
        //递归排序左半数组
        sort(array, left, r - 1);
        //递归排序右半数组
        sort(array, r + 1, right);
    }

    private static void test(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * n * 10);
        }
        System.out.printf("┏━━▶ %d个数据的数组\n", n);
        System.out.println(Arrays.toString(array));
        long start = System.nanoTime();
        sort(array);
        long end = System.nanoTime();
        System.out.println("┣━━▶ 排序结果");
        System.out.println(Arrays.toString(array));
        System.out.println("┗━━▶ 排序耗时：" + (end - start) + "ns");
    }

    public static void main(String[] args) {
        test(8);
    }
}
