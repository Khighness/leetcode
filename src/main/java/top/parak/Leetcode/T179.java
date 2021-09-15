package top.parak.Leetcode;

import java.util.Arrays;

/**
 * @author KHighness
 * @since 2021-07-18
 * @apiNote 179. 最大数
 */
public class T179 {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] words = new String[len];
        for (int i = 0; i < nums.length; i++) {
            words[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(words, (a, b) -> (b + a).compareTo(a + b));
        if (words[0].equals("0")) return "0";
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            builder.append(word);
        }
        return builder.toString();
    }

    public String largestNumber2(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        if (nums[0] == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (int num : nums) {
            ans.append(num);
        }
        return ans.toString();
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pivot = nums[start];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            long x = 10, y = 10;
            while (nums[i] >= x) {
                x *= 10;
            }
            while (pivot >= y) {
                y *= 10;
            }
            if (nums[i] * y + pivot > nums[i] + pivot * x) {
                index += 1;
                swap(nums, index, i);
            }
        }
        swap(nums, index, start);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
