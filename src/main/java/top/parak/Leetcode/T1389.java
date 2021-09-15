package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2020-09-23
 * @apiNote 1389. 按既定顺序创建目标数组
 */
public class T1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        int[] target = new int[len];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(index[i], nums[i]);
        }
        for (int i = 0; i < len; i++) {
            target[i] = list.get(i);
        }
        return target;
    }
}
