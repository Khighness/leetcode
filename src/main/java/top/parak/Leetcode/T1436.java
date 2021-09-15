package top.parak.Leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * @author KHighness
 * @since 2020-09-25
 * @apiNote 1436. 旅行终点站
 */
public class T1436 {

    /**
     * Solution:
     * 起点在list[i][0],终点在list[i][1],
     * 起点和重点只会出现一次.
     *
     * 遍历数组, 用HashMap记录.
     * Key存String值,Value存下标.
     * 重复的Key将其从HashMap移除.
     * 最后剩下的就是起点和终点.
     * 其中下标为1的点为终点.
     */
    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> siMap = new HashMap<>(paths.size() + 1);
        for (int i = 0; i < paths.size(); i++) {
            String s1 = paths.get(i).get(0), s2 = paths.get(i).get(1);
            if (siMap.containsKey(s1)) {
                siMap.remove(s1);
            } else {
                siMap.put(s1, 0);
            }
            if (siMap.containsKey(s2)) {
                siMap.remove(s2);
            } else {
                siMap.put(s2, 1);
            }
        }
        for (HashMap.Entry<String, Integer> entry : siMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("NULL");
    }
}
