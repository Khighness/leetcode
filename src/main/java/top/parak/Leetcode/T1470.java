package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/22 12:48
 * @apiNote 1470. 重新排列数组
 */

import java.util.Arrays;

/**
 * Problem:
 *给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 */

public class T1470 {

    public int[] shuffle(int[] nums, int n) {
        // 重新排列后
        // X: index -> 2 * index
        // Y: index -> 2 * (index - n) + 1
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i < n) {
                newNums[2 * i] = nums[i];
            } else {
                newNums[2 *  (i - n) + 1] = nums[i];
            }
        }
        return newNums;
    }

    public static void main(String[] args) {
        Arrays.stream(new T1470().shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)).forEach(System.out::println);
    }

}
