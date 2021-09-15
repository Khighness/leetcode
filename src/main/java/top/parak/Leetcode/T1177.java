package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 1177. 构建回文串检测
 */
public class T1177 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            res.add(false);
        }
        return res;
    }

}
