package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/14
 * @apiNote 1122. 数组的相对排序
 */

import java.util.*;

/**
 * Problem:
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 */
public class T1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        // 把arr1的值和出现次数存入map
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            } else {
                map.put(arr1[i], 1);
            }
        }
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                for (int k = 0; k < map.get(arr2[i]); k++) {
                    arr1[index++] = arr2[i];
                }
                map.remove(arr2[i]);
            }
        }
        // 对于存在arr1但是不存在于arr2的元素进行排序
        List<Integer> list = new LinkedList();
        for (Integer integer : map.keySet()) {
            list.add(integer);
        }
        Collections.sort(list);
        for (Integer integer : list) {
            for (int i = 0; i < (int) map.get(integer); i++) {
                arr1[index++] = integer;
            }
        }
        return arr1;
    }

}
