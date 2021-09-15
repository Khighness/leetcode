package top.parak.Practice.Zoom;

/**
 * @author KHighness
 * @since 2021-08-28
 */
public class M1 {
    public int find132Pattern (int[] nums) {
        // write code here
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i]< nums[k] && nums[k] < nums[j]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
