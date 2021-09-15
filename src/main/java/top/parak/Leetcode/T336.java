package top.parak.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author KHighness
 * @since 2020-11-14
 * @apiNote 336. 回文对
 */
public class T336 {

    public List<List<Integer>> unacceptedSolution(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    if (isPalindrome(words[i] + words[j])) {
                        res.add(Arrays.asList(i, j));
                    }
                }
            }
        }
        return res;
    }

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

    public boolean isPalindrome(String s) {
        int l = s.length();
        for (int i = 0; i < l / 2; i++) {
            if (s.charAt(i) != s.charAt(l - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
