package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-10-01
 * @apiNote 136. 只出现一次的数字
 */
public class T136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }
}
