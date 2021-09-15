package top.parak.Algorithm.Sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author KHighness
 * @since 2021-03-05
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

    public static void sort2(int[] arr, int l, int r) {
        Stack<Integer> stack = new Stack<>();
        stack.push(l);
        stack.push(r);
        int pivot;
        while (!stack.isEmpty()) {
            // 弹
            r = stack.pop();
            l = stack.pop();
            pivot = partition(arr, l, r);
            if (l < pivot - 1) {
                stack.push(l);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < r) {
                stack.push(pivot + 1);
                stack.push(r);
            }
        }
    }

    private static int partition(int[] arr, int l, int r) {
        // 中间轴
        int pivot = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= pivot) r--;
            arr[l] = arr[r];
            while (l < r && arr[l] <= pivot) l++;
            arr[r] = arr[l];
        }
        // 起始交换
        arr[l] = pivot;
        return l;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
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
