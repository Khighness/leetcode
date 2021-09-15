package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-01
 * @apiNote 27. 移除元素
 */
public class T27 {
    /**
     * 双指针
     * i指向头，j指向尾
     * 将数组分为前后两个部分
     * i遍历数组，出现目标值，ij交换
     */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0, j = len - 1;
        while (i <= j) {
            if (nums[i] == val) {
                swap(nums, i, j);
                i--; j--;
            }
            i++;
        }
        return j + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
