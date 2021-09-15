package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author KHighness
 * @since 2021-05-28
 * @apiNote 131. 分割回文串
 */
public class T131 {
    private Deque<String> cur = new LinkedList<>();
    private List<List<String>> res = new ArrayList<>();
    private char[] arr;
    private int len;

    public List<List<String>> partition(String s) {
        arr = s.toCharArray();
        len = arr.length;
        dfs(s, 0);
        return res;
    }

    /**
     * 回溯
     *
     * @param s     字符串
     * @param index 决策位
     */
    private void dfs(String s, int index) {
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
