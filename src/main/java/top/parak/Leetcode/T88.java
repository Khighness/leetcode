package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-20
 * @apiNote 88. 合并两个有序数组
 */
public class T88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1, i1 = m - 1, i2 = n - 1;
        while (i1 >= 0 && i2 >= 0) {
            if (nums1[i1] > nums2[i2]) {
                nums1[i--] = nums1[i1--];
            } else {
                nums1[i--] = nums2[i2--];
            }
        }
        while (i1 >= 0) nums1[i--] = nums1[i1--];
        while (i2 >= 0) nums1[i--] = nums2[i2--];
    }
}
