package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/12/1
 * @apiNote 34. 在排序数组中查找元素的第一个和最后一个位置
 */

import java.util.Arrays;

/**
 * Problem:
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 */
public class T34 {

    public int binarySearch(int[] nums, int target) {
        int min = 0, max = nums.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (nums[mid] > target) {
                max = mid - 1;
            } else if (nums[mid] < target) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int mid = binarySearch(nums, target);
        if (mid == -1) {
            return new int[]{-1, -1};
        }
        int left = mid, right = mid;
        while (left != -1) {
            if (nums[left] != target) {
                break;
            }
            left--;
        }
        while (right != nums.length) {
            if (nums[right] != target) {
                break;
            }
            right++;
        }
        return new int[]{++left, --right};
    }

}
