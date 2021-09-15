package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-07
 * @apiNote 457. 环形数组是否存在循环
 */
public class T457 {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int slow = i;
            int fast = next(nums, i);

            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)]  > 0) {
                if (slow == fast) {
                    if (slow != next(nums, slow))  {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
        }

        return false;
    }

    private int next(int[] nums, int i) {
        int n = nums.length;
        return ((i + nums[i] % n) + n) % n;
    }
}
