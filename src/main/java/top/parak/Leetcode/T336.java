package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/14
 * @apiNote 336. 回文对
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * 给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 */
public class T336 {

    /**
     * 暴力，超时
     * @param words
     * @return
     */
    public List<List<Integer>> unacceptedSolution(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    if (isPalindrome(new StringBuffer().append(words[i]).append(words[j]).toString())) {
                        res.add(Arrays.asList(i, j));
                    }
                }
            }
        }
        return res;
    }

    /**
     * 使用哈希
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            hashMap.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            String reverse = new StringBuffer(words[i]).reverse().toString();
            int l = reverse.length();
            for (int k = 0; k <= l; k++) {
                String left = reverse.substring(0, k), right = reverse.substring(k);
                if (hashMap.containsKey(left) && hashMap.get(left) != i && isPalindrome(right)) {
                    res.add(Arrays.asList(hashMap.get(left), i));
                }
                if (hashMap.containsKey(right) && hashMap.get(right) != i && isPalindrome(left) && k > 0) {
                    res.add(Arrays.asList(i, hashMap.get(right)));
                }
            }
        }
        return res;
    }

    /**
     * 判断回文
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int l = s.length();
        for (int i = 0; i < l / 2; i++) {
            if (s.charAt(i) != s.charAt(l - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String[] words = new String[]{"k",""};
        new T336().palindromePairs(words).stream().forEach( ll -> {
            System.out.println(ll);
        });
    }
}
