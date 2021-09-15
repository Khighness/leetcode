package top.parak.Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KHighness
 * @since 2021-07-27
 * @apiNote 128. 最长连续序列
 */
public class T128 {

    public int longestConsecutive(int[] nums) {
        // 存储左边界
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int ans = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int i = num, cur = 1;
                while (set.contains(++i)) {
                    cur++;
                }
                ans = Math.max(ans, cur);
                set.add(num);
            }
        }
        return ans;
    }

}
