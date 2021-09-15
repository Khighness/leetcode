package top.parak.Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author KHighness
 * @since 2021-07-24
 * @apiNote 215. 数组中的第K个最大元素
 */
public class T215 {

    /**
     * K大时用大根堆，淘汰前（K - 1）个数
     * K小时用小根堆，淘汰前（len - K）个数
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (k <= len - k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(len, Comparator.comparingInt(a -> a));
            for (int num : nums) minHeap.add(num);
            for (int i = 0; i < len - k; i++) minHeap.poll();
            return minHeap.peek();
        } else {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, Comparator.comparingInt(a -> (-a)));
            for (int num : nums) maxHeap.add(num);
            for (int i = 0; i < k - 1; i++) maxHeap.poll();
            return maxHeap.peek();
        }
    }

    /**
     * 面试需要自己写堆
     */
    public int findKthLargest2(int[] arr, int k) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }
        for (int j = len - 1; j >= 0; j--) {
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
            if (j == len - k) {
                return arr[len - k];
            }
        }
        return -1;
    }

    /**
     * 数组 -> 大顶堆
     */
    private void adjustHeap(int[] arr, int i, int len) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < len; k = k * 2 + 1) {
            if (k + 1 < len && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    /**
     * 交换数据
     */
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
