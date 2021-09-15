package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-31
 * @apiNote 剑指 Offer 40. 最小的k个数
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[k];
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustMinHeap(arr, i, n);
        }
        for (int i = n - 1; i >= n - k; i--) {
            swap(arr, 0, i);
            ans[n - 1 - i] = arr[i];
            adjustMinHeap(arr, 0, i);
        }
        return ans;
    }

    /**
     * 数组 -> 小根堆
     */
    private void adjustMinHeap(int[] arr, int i, int len) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
            if (k + 1 < len && arr[k] > arr[k + 1]) {
                k++;
            }
            if (arr[k] < temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
