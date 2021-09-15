package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-10-01
 * @apiNote 852. 山脉数组的峰顶索引
 */
public class T852 {

    /**
     * 二分
     */
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 三分
     */
    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 1;
        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;
            if (arr[mid1] < arr[mid2]) {
                left = mid1 + 1;
            } else {
                right = mid2 - 1;
            }
        }
        return left;
    }

}
