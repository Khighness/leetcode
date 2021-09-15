package top.parak.Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author KHighness
 * @since 2020-10-02
 * @apiNote 905. 按奇偶排序数组
 */
public class T905 {

    public int[] sortArrayByParity(int[] A) {
        List<Integer> odd = new LinkedList<>();
        List<Integer> even = new LinkedList<>();
        for (int a : A) {
            if (a % 2 == 0) {
                even.add(a);
            } else {
                odd.add(a);
            }
        }
        even.addAll(odd);
        return even.stream().mapToInt(Integer::valueOf).toArray();
    }

}
