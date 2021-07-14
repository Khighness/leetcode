package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/2 1:29
 * @apiNote 476. 数字的补数
 */

/**
 * Problem:
 * 给定一个正整数，输出它的补数。
 * 补数是对该数的二进制表示取反。
 */
public class T476 {
    public int findComplement(int num) {
        String n1 = Integer.toBinaryString(num);
        String n2 = "";
        int len = n1.length();
        for (int i = 0; i < len; i++) {
            n2 += '1';
        }
        int n = Integer.parseInt(n2, 2);
        return n ^ num;
    }
}
