package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/23 13:37
 * @apiNote 1313. 解压缩编码列表
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * 给你一个以行程长度编码压缩的整数列表 nums 。
 * 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
 * 请你返回解压后的列表。
 */
public class T1313 {

    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i += 2) {
            len += nums[i];
        }
        int[] target = new int[len];
        int index = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            for (int k = 1; k <= nums[i]; k++) {
                target[index] = nums[i+1];
                index++;
            }
        }
        return target;
    }

}
