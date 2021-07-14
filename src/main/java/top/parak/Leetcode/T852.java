package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/1 16:40
 * @apiNote 852. 山脉数组的峰顶索引
 */

/**
 * Problem:
 * 我们把符合下列属性的数组 A 称作山脉：
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
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
