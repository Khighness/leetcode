package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/1 18:04
 * @apiNote 191. 位1的个数
 */

/**
 * Problem:
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class T191 {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n = n & (n - 1);
        }
        return ans;
    }
}
