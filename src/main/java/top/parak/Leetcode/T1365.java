package top.parak.Leetcode;

import java.util.*;

/**
 * @author KHighness
 * @since 2020-09-23
 * @apiNote 1365. 有多少小于当前数字的数字
 */
public class T1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 相同的值出现频率
        // 牛逼：索引即数值
        int[] freq = new int[101];
        for (int n : nums) {
            freq[n]++;
        }
        // 频率从前到后累加
        // freq[index-1]记录比自己小的数的数量
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                ans[i] = freq[nums[i] - 1];
        }
        return ans;
    }

    /**
     * 哈希解法
     */
    public int[] hashSolution(int[] nums) {
        int len = nums.length;
        Map<Integer, Set<Integer>> valueIndex = new HashMap<>(len); // 预存每个值与索引对应
        for (int i = 0; i < len; i++) {
            if (!valueIndex.containsKey(nums[i])) valueIndex.put(nums[i], new HashSet<>());
            valueIndex.get(nums[i]).add(i);
        }
        int[] sortedArr = Arrays.copyOf(nums, len), res = new int[len];
        Arrays.sort(sortedArr);
        for (int si = len - 1; si >= 0; si--) { // 倒序，方便处理同值的情况
            // 此行为补充优化：前面还有同值的，那就跳过这次，等下次再一并赋值
            if (si - 1 >= 0 && sortedArr[si] == sortedArr[si - 1]) continue;
            // 同值的所有索引都更新
            for (int i : valueIndex.get(sortedArr[si])) res[i] = si;
        }
        return res;
    }
}
