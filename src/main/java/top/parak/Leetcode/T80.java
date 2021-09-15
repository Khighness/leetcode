package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-20
 * @apiNote 80. 删除有序数组中的重复项 II
 */
public class T80 {
    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }

    private int process(int[] arr, int k) {
        int index = 0;
        for (int a : arr) {
            if (index < k || arr[index - k] != a) {
                arr[index++] = a;
            }
        }
        return index;
    }
}
