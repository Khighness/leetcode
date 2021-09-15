package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-01
 * @apiNote 剑指 Offer 51. 数组中的逆序对
 */
public class Offer51 {
    private int count;

    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        resolve(nums, 0, nums.length - 1, temp);
        return count;
    }

    private void resolve(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            resolve(nums, left, mid, temp);
            resolve(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                count += mid - i + 1;
                temp[t++] = arr[j++];
            }
        }
        while(i <= mid) temp[t++] = arr[i++];
        while (j <= right) temp[t++] = arr[j++];
        t = 0; i = left;
        while (i <= right) {
            arr[i++] = temp[t++];
        }
    }
}
