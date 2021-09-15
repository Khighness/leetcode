package top.parak.Practice.ST;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author KHighness
 * @since 2021-08-11
 */
public class T2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param k int整型
     * @return int整型一维数组
     */
    public int[] topKFrequent (int[] nums, int k) {
        // write code here
        // 存储频数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 建立小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            if (heap.size() < k) {
                heap.add(key);
            } else if (map.get(key) > map.get(heap.peek())) {
                heap.poll();
                heap.offer(key);
            }
        }
        int[] res = new int[k];
        int index = 0;
        for (int num : heap) {
            res[index++] = num;
        }
        return res;
    }

}
