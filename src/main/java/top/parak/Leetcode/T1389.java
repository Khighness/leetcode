package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/23 13:14
 * @apiNote 1389. 按既定顺序创建目标数组
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
 * 1.目标数组 target 最初为空。
 * 2.按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
 * 3.重复上一步，直到在 nums 和 index 中都没有要读取的元素。
 * 请你返回目标数组。
 */
public class T1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        int[] target = new int[len];
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            list.add(index[i], nums[i]);
        }
        for (int i = 0; i < len; i++) {
            target[i] = list.get(i);
        }
        return target;
    }
}
