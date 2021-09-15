package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-12-01
 * @apiNote 34. 在排序数组中查找元素的第一个和最后一个位置
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

    public int[] searchRange2(int[] nums, int target) {
        int l = getLeftBorder(nums, target);
        int r = getRightBorder(nums, target);
        if (l == -2 || r == -2) return new int[] {-1, -1};
        if (r - l > 1) return new int[] {l + 1, r - 1};
        return new int[] {-1, -1};
    }

    private int getLeftBorder(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int leftBorder = -2;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] >= target) {
                r = m - 1;
                leftBorder = r;
            } else {
                l = m + 1;
            }
        }
        return leftBorder;
    }

    private int getRightBorder(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int rightBorder = -2;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
                rightBorder = l;
            }
        }
        return rightBorder;
    }

}
