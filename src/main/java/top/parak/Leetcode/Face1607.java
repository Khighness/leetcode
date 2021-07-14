package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/26 0:46
 * @apiNote 面试题 16.07. 最大数值
 */

/**
 * Problem:
 * 编写一个方法，找出两个数字a和b中最大的那一个。
 * 不得使用if-else或其他比较运算符。
 */

/**
 * Solution:
 * 根据数学公式
 * Max(a, b) = (|a - b| + a + b) / 2
 */
public class Face1607 {
    public int maximum(int a, int b) {
        long la = a;
        long lb = b;
        int ans = (int) ((Math.abs(la - lb) + la + lb) / 2);
        return ans;
    }
}
