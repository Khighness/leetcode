package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/23 14:41
 * @apiNote 1365. 有多少小于当前数字的数字
 */

import java.util.*;

/**
 * Problem:
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * 以数组形式返回答案。
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

    public static void main(String[] args) {
        Arrays.stream(new T1365().hashSolution(new int[]{7, 7, 7, 7})).forEach(System.out::println);
    }
}
