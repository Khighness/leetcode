package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author KHighness
 * @since 2021-05-28
 * @apiNote 93. 复原 IP 地址
 */
public class T93 {
    Deque<String> cur = new LinkedList<>();
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if (len < 4 || len > 12) {
            return res;
        }
        dfs(s, len, 0, 0);
        return res;
    }

    /**
     * @param s      字符串
     * @param len    长度
     * @param index  当前下标
     * @param split  第几段(0-3)
     */
    private void dfs(String s, int len, int index, int split) {
        if (index == len) {
            if (split == 4) {
                res.add(String.join(".", cur));
            }
            return;
        }
        // 剪枝：len剩下的部分不够分，或者len剩下的部分有剩余
        if (len - index < (4 - split) || len - index > 3 * (4 - split)) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (index + i >= len) {
                break;
            }
            int ip = getIP(s, index, index + i);
            if (ip != -1) {
                cur.addLast(ip + "");
                dfs(s, len, index + i + 1, split + 1);
                cur.removeLast();
            }
        }
    }

    private int getIP(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return -1;
        }
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        return res > 255 ? -1 : res;
    }
}
