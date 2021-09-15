package top.parak.Leetcode;

import java.util.*;

/**
 * @author KHighness
 * @since 2020-11-14
 * @apiNote 1122. 数组的相对排序
 */
public class T1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        // 把arr1的值和出现次数存入map
        for (int value : arr1) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }
        int index = 0;
        for (int value : arr2) {
            if (map.containsKey(value)) {
                for (int k = 0; k < map.get(value); k++) {
                    arr1[index++] = value;
                }
                map.remove(value);
            }
        }
        // 对于存在arr1但是不存在于arr2的元素进行排序
        List<Integer> list = new ArrayList<>();
        list.addAll(map.keySet());
        Collections.sort(list);
        for (Integer integer : list) {
            for (int i = 0; i < (int) map.get(integer); i++) {
                arr1[index++] = integer;
            }
        }
        return arr1;
    }

}
