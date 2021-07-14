package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-28
 * @apiNote 131. 分割回文串
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 */
public class T131 {
    Deque<String> cur = new LinkedList<>();
    List<List<String>> res = new ArrayList<>();
    char[] arr;
    int len;

    public List<List<String>> partition(String s) {
        arr = s.toCharArray();
        len = arr.length;
        dfs(s, 0);
        return res;
    }

    private void dfs(String s,  int index) {
        if (index == len) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < len; i++) {
            if (isOK(s, index, i)) {
                cur.addLast(new String(arr, index, i + 1 - index));
                dfs(s, i + 1);
                cur.removeLast();
            }
        }
    }

    private boolean isOK(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
