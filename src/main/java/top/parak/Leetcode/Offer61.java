package top.parak.Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author KHighness
 * @since 2021-08-01
 * @apiNote 剑指 Offer 61. 扑克牌中的顺子
 */
public class Offer61 {
    /**
     * 跳过0
     * (1) 无重复
     * (2) max - min <= 5
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 15, max = -1;
        for (int num : nums) {
            if (num == 0) continue;
            if (set.contains(num)) return false;
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return max - min <= 4;
    }
}
