package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-07-28
 * @apiNote 31. 下一个排列
 */
public class T31 {
    /**
     * 1. 从后往前查找第一个顺序对(i, i+1)，满足a[i] < a[i + 1]
     * 2. 从[i + 1， n)中从后往前查找第一个元素满足a[i] < a[j]
     * 3. 交换a[i]和a[j]，反转降序区间[i + 1, n)为升序
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = len - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int l = start, r = nums.length - 1;
        while (l < r) {
            swap(nums, l, r);
            l++; r--;
        }
    }
}
