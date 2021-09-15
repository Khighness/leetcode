package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-03
 * @apiNote 581. 最短无序连续子数组
 */
public class T581 {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length ;
        int i = 0, j = n - 1;
        while (i < j && nums[i] <= nums[i + 1]) i++;
        while (i < j && nums[j] >= nums[j - 1]) j--;
        int l = i, r = j;
        int min = nums[i], max = nums[j];
        for (int u = l; u <= r; u++) {
            if (nums[u] < min) {
                while (i >= 0 && nums[i] > nums[u]) i--;
                min = i >= 0? nums[i] : Integer.MIN_VALUE;
            }
            if (nums[u] > max) {
                while (j < n && nums[j] < nums[u]) j++;
                max = j < n ? nums[j] : Integer.MAX_VALUE;
            }
        }
        return i == j ? 0 : (j - 1) - (i + 1) + 1;
    }

}
