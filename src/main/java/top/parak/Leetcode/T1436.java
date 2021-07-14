package top.parak.Leetcode;

/**
 * @author: KHighness
 * @date: 2020/9/25 22:10
 * @apiNote: 1436. 旅行终点站
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem:
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，
 * 其中 paths[i] = [cityAi, cityBi]表示该线路将会从 cityAi 直接前往 cityBi 。
 * 请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 * 题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
 */

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
public class T1436 {

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
        for (HashMap.Entry entry : siMap.entrySet()) {
            if ((Integer) entry.getValue() == 1) {
                return (String) entry.getKey();
            }
        }
        throw new RuntimeException("NULL");
    }
}
