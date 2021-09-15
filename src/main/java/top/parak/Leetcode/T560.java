package top.parak.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KHighness
 * @since 2021-05-17
 * @apiNote 560. 和为K的子数组
 */
public class T560 {

    /**
     * 前缀和
     */
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int ans = 0;
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                if (prefixSum[right + 1] - prefixSum[left] == k)
                    ans++;
            }
        }
        return ans;
    }

    /**
     * 哈希表优化
     */
    public int subarraySum2(int[] nums, int k) {
        // 记录前缀和对应的个数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0, ans = 0;
        for (int num : nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - k)) {
                ans += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return ans;
    }

}
