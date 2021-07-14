package top.parak.Leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author KHighness
 * @since 2021-05-20
 * @apiNote 692. 前K个高频单词
 */

/**
 * Problem:
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class T692 {

    /**
     * 小根堆
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>((s1, s2) -> {
            if (map.get(s1).equals(map.get(s2)))
                return s2.compareTo(s1);
            else
                return map.get(s1) - map.get(s2);
        });
        for (String s : map.keySet()) {
            heap.offer(s);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<String> res = new ArrayList<>(k);
        while (heap.size() > 0) {
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 哈希表
     * key: 单词，value: 频率
     */
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> {
            // 频率相等，按照字典序
            if (map.get(a).equals(map.get(b))) {
                return a.compareTo(b);
            } else {
                // 频率降序
                return map.get(b) - map.get(a);
            }
        });
        return keys.subList(0, k);
    }

}
